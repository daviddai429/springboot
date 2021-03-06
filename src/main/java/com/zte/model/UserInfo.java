package com.zte.model;

import java.util.List;

/**
 * 用戶信息表
 * @author david
 *
 */
public class UserInfo extends BaseModel {
	
	private String username;
	private String password;
	private String usertype;
	private Integer enabled;
	private String realname;
	private String qq;
	private String email;
	private String tel;
	private List<String> roleStrlist;
	private List<String> menuStrlist;
	
	
	public List<String> getMenuStrlist() {
		return menuStrlist;
	}
	public void setMenuStrlist(List<String> menuStrlist) {
		this.menuStrlist = menuStrlist;
	}
	public List<String> getRoleStrlist() {
		return roleStrlist;
	}
	public void setRoleStrlist(List<String> roleStrlist) {
		this.roleStrlist = roleStrlist;
	}
	
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUsertype() {
		return usertype;
	}
	public void setUsertype(String usertype) {
		this.usertype = usertype;
	}
	public Integer getEnabled() {
		return enabled;
	}
	public void setEnabled(Integer enabled) {
		this.enabled = enabled;
	}
	public String getRealname() {
		return realname;
	}
	public void setRealname(String realname) {
		this.realname = realname;
	}
	public String getQq() {
		return qq;
	}
	public void setQq(String qq) {
		this.qq = qq;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	
	

}
