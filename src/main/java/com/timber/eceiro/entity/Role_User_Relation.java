package com.timber.eceiro.entity;

import java.io.Serializable;

public class Role_User_Relation implements Serializable{

	private UserInfo userInfo;
	private RoleInfo roleInfo;

	public UserInfo getUserInfo() {
		return userInfo;
	}
	public void setUserInfo(UserInfo userInfo) {
		this.userInfo = userInfo;
	}
	public RoleInfo getRoleInfo() {
		return roleInfo;
	}
	public void setRoleInfo(RoleInfo roleInfo) {
		this.roleInfo = roleInfo;
	}
	
	
	
}
