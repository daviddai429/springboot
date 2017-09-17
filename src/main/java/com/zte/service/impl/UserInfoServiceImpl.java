package com.zte.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.zte.mapper.UserInfoMapper;
import com.zte.model.UserInfo;
import com.zte.service.UserInfoService;

@Service
public class UserInfoServiceImpl implements UserInfoService {
	@Autowired
	UserInfoMapper userInfoMapper;

	@Override
	public List<UserInfo> findUserInfo(UserInfo userInfo) {
		PageHelper.startPage(userInfo.getPage(), userInfo.getRows());
		List<UserInfo> list = userInfoMapper.select(null);
		return list;
	}

	/* 
	 * 新增用户
	 * @see com.zte.springboot.service.UserInfoService#addUserInfo(com.zte.springboot.pojo.UserInfo)
	 */
	@Override
	public void addUserInfo(UserInfo userInfo) {
		userInfoMapper.insert(userInfo);
		
	}

	@Override
	public UserInfo login(UserInfo userInfo) {
		UserInfo loginUser = userInfoMapper.selectOne(userInfo);
		return loginUser;
	}

}
