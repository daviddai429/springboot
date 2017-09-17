package com.zte.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zte.model.UserInfo;
import com.zte.service.UserInfoService;

@Controller
@RequestMapping("/user")
public class UserInfoController {

	@Autowired
	UserInfoService userInfoService;

	/**
	 * 查询用户信息
	 * @return
	 */
	@RequestMapping("/check")
	@ResponseBody
	public List<UserInfo> findUserInfo() {
		return userInfoService.findUserInfo(new UserInfo());
	}
	
	@RequestMapping("/add")
	@ResponseBody
	public String addUserInfo(UserInfo userInfo){
		try {
			userInfoService.addUserInfo(userInfo);
			return "success";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "fail";
	}

}
