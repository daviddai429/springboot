package com.zte.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zte.model.UserInfo;

/**
 * 用户登陆
 * 
 * @author david
 *
 */
@Controller
@RequestMapping("/login")
public class Login {

	@RequestMapping
	@ResponseBody
	public String login(UserInfo userInfo) {
		if (null != userInfo.getUsername() && null != userInfo.getPassword()) {

			Subject currentUser = SecurityUtils.getSubject();
			UsernamePasswordToken token = new UsernamePasswordToken(userInfo.getUsername(), userInfo.getPassword(),
					"login");
			currentUser.login(token);
			// 认证成功
			if (currentUser.isAuthenticated()) {
				System.out.println("用户[" + userInfo.getUsername() + "]登录认证通过(这里可以进行一些认证通过后的一些系统参数初始化操作)");
				return "success";
			} else {
				token.clear();
				System.out.println("用户[" + userInfo.getUsername() + "]登录认证失败,重新登陆");
				return "fail";
			}
		}
		return "fail";
	}

}
