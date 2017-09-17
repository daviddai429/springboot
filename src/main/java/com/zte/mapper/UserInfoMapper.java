package com.zte.mapper;

import java.util.List;

import com.zte.model.UserInfo;

public interface UserInfoMapper {

	UserInfo selectOne(UserInfo userInfo);

	List<UserInfo> select(UserInfo userInfo);

	void insert(UserInfo userInfo);

}
