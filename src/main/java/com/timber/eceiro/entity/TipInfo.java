package com.timber.eceiro.entity;

import java.io.Serializable;

/**
 * 安全防护管理
 * @author 李旭日
 *
 */
public class TipInfo implements Serializable{
	
	private int id;  //id
	private String equipment;  //作业活动、项目、设备
	private String source;  //危险源、危险因素
	private String location;  //位置
	private String result;  //导致的事故、后果
	private int lec;  //LEC风险等级
	private String tclass;  //物业公司管理等级
	private String measure;  //控制措施
	private String staff;  //控制措施
	private UserInfo userInfo;  //创建人


	private String qrcode;  //二维码




	public String getQrcode() {
		return qrcode;
	}
	public void setQrcode(String qrcode) {
		this.qrcode = qrcode;
	}
	public String getStaff() {
		return staff;
	}
	public void setStaff(String staff) {
		this.staff = staff;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEquipment() {
		return equipment;
	}
	public void setEquipment(String equipment) {
		this.equipment = equipment;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	public int getLec() {
		return lec;
	}
	public void setLec(int lec) {
		this.lec = lec;
	}
	public String getTclass() {
		return tclass;
	}
	public void setTclass(String tclass) {
		this.tclass = tclass;
	}
	public String getMeasure() {
		return measure;
	}
	public void setMeasure(String meassure) {
		this.measure = meassure;
	}
	public UserInfo getUserInfo() {
		return userInfo;
	}
	public void setUserInfo(UserInfo userInfo) {
		this.userInfo = userInfo;
	}


	

}
