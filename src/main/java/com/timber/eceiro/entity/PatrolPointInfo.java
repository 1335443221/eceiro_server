package com.timber.eceiro.entity;

import java.io.Serializable;

public class PatrolPointInfo implements Serializable{
	
	private int id;  //id
	private String number;  //巡检点编号
	private String name;  //巡检位置
	private String detail;  //具体位置
	private UserInfo userInfo;  //创建人
	private int company_id;  //


	private long create_at;  //创建时间

	public int getId() {
		return id;
	}
	public int getCompany_id() {
		return company_id;
	}
	public void setCompany_id(int company_id) {
		this.company_id = company_id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}

	public UserInfo getUserInfo() {
		return userInfo;
	}
	public void setUserInfo(UserInfo userInfo) {
		this.userInfo = userInfo;
	}
	public long getCreate_at() {
		return create_at;
	}
	public void setCreate_at(long create_at) {
		this.create_at = create_at;
	}
	
	
	

}
