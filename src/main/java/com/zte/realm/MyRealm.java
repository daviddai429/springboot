package com.zte.realm;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.zte.mapper.UserInfoMapper;
import com.zte.mapper.UserMenuMapper;
import com.zte.mapper.UserRoleMapper;
import com.zte.model.UserInfo;

public class MyRealm extends AuthorizingRealm {


    //一般这里都写的是servic，我省略了service的接口和实现方法直接调用的dao
    @Autowired
    private UserInfoMapper userInfoMapper;
    @Autowired
    private UserRoleMapper userRoleMapper;
    @Autowired
    private UserMenuMapper userMenuMapper;

	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        //获取当前登录输入的用户名，等价于(String) principalCollection.fromRealm(getName()).iterator().next();
//        String loginName = (String) super.getAvailablePrincipal(principalCollection);
        UserInfo user = (UserInfo) principalCollection.getPrimaryPrincipal();
//        //到数据库查是否有此对象
        if (user != null) {
            //权限信息对象info,用来存放查出的用户的所有的角色（role）及权限（permission）
            SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
            //用户的角色集合
            info.addRoles(user.getRoleStrlist()); 
            //用户的权限集合
            info.addStringPermissions(user.getMenuStrlist()); 

            return info;
        }
        // 返回null的话，就会导致任何用户访问被拦截的请求时，都会自动跳转到unauthorizedUrl指定的地址
        return null;
    
	}

	/*
	 * 对当前登录的用户进行身份认证
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
		UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        //查出是否有此用户
        UserInfo userInfo = new UserInfo();
        userInfo.setUsername(token.getUsername());
        userInfo.setPassword(new String(token.getPassword()));
        //提供登陆验证方案
        UserInfo hasUser = userInfoMapper.selectOne(userInfo);
        if (hasUser != null) {
            // 若存在，将此用户存放到登录认证info中，无需自己做密码对比，Shiro会为我们进行密码对比校验
            List<String> rolenames = userRoleMapper.findRoleByUid(hasUser.getId());//获取用户角色
            List<String> menunames = userMenuMapper.findMenuByUid(hasUser.getId());//获取用户权限
            List<String> roleStrlist=new ArrayList<String>();//用户的角色集合
            List<String> menuStrlist=new ArrayList<String>();//用户的权限集合
            for (String rolename : rolenames) {
                roleStrlist.add(rolename);
            }
            for (String menuname : menunames) {
            	menuStrlist.add(menuname);
            }
            hasUser.setRoleStrlist(roleStrlist);
            hasUser.setMenuStrlist(menuStrlist);
//            Session session = SecurityUtils.getSubject().getSession();
//            session.setAttribute("user", hasUser);//成功则放入session
         // 若存在，将此用户存放到登录认证info中，无需自己做密码对比，Shiro会为我们进行密码对比校验
            return new SimpleAuthenticationInfo(hasUser, hasUser.getPassword(), getName());
        }
        return null;
	}
}
