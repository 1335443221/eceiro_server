package com.timber.eceiro.entity;

import java.io.Serializable;

public class Image_Desc implements Serializable{
	private int id;  //id
	private String content;  //内容
	private UserInfo createUserInfo;   //创建人
	private int create_at;  //创建时间
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}


	public UserInfo getCreateUserInfo() {
		return createUserInfo;
	}
	public void setCreateUserInfo(UserInfo createUserInfo) {
		this.createUserInfo = createUserInfo;
	}
	public int getCreate_at() {
		return create_at;
	}
	public void setCreate_at(int create_at) {
		this.create_at = create_at;
	}
	
	

}
