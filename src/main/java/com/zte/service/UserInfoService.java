package com.zte.service;

import java.util.List;

import com.zte.model.UserInfo;

public interface UserInfoService {

	/**
	 * 查询所有用户
	 * @param userInfo
	 * @return
	 */
	List<UserInfo> findUserInfo(UserInfo userInfo);

	/**
	 * 新增用户
	 * @param userInfo
	 */
	void addUserInfo(UserInfo userInfo);

	/**
	 * 登陆
	 * @param userInfo
	 * @return
	 */
	UserInfo login(UserInfo userInfo);

}
