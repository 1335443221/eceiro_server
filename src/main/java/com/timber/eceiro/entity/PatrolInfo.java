package com.timber.eceiro.entity;

import java.io.Serializable;

public class PatrolInfo implements Serializable{
	private int id;  //id
	private PatrolPointInfo patrol_pointInfo;  //巡检点id
	private int type;  //巡检类型（1：高压配；2：低压配；3：水房；4：锅炉房；5：卫生间；6：开水间）巡检类型（1：高压配；2：低压配；3：水房；4：锅炉房；5：卫生间；6：开水间）
	private String content;  //巡检内容
	private int time_type;  //巡检时间段类型（1：早班；2：晚班）
	private int count;  //巡检次数
	private UserInfo createUserInfo;  //创建人
	private int create_at;  //创建时间


	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public PatrolPointInfo getPatrol_pointInfo() {
		return patrol_pointInfo;
	}
	public void setPatrol_pointInfo(PatrolPointInfo patrol_pointInfo) {
		this.patrol_pointInfo = patrol_pointInfo;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getTime_type() {
		return time_type;
	}
	public void setTime_type(int time_type) {
		this.time_type = time_type;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
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
