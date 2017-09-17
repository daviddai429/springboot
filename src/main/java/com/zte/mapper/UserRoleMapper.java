package com.zte.mapper;

import java.util.List;

public interface UserRoleMapper {
	
	List<String> findRoleByUid(Integer id);
	List<String> findMenuByUid(Integer id);
}
