package com.zte.mapper;

import java.util.List;

public interface UserMenuMapper {
	
//	userMenuMapper.findMenuByUid(hasUser.getId())
	List<String> findMenuByUid(Integer id);

}
