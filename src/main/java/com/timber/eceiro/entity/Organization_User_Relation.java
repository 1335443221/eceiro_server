package com.timber.eceiro.entity;

import java.io.Serializable;

public class Organization_User_Relation implements Serializable{
	
	private Organization organization;
	private UserInfo userInfo;
	public Organization getOrganization() {
		return organization;
	}
	public void setOrganization(Organization organization) {
		this.organization = organization;
	}
	public UserInfo getUserInfo() {
		return userInfo;
	}
	public void setUserInfo(UserInfo userInfo) {
		this.userInfo = userInfo;
	}
	
	

}
