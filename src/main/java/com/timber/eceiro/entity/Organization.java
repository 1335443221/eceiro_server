package com.timber.eceiro.entity;

import java.io.Serializable;

public class Organization implements Serializable{
	private int id; //id
	private String name;  //机构名称
	private String number;  //机构编码
	private int oclass;  //机构级别
	private int father_id;  //父机构id
	private String remark;  //备注
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public int getOclass() {
		return oclass;
	}
	public void setOclass(int oclass) {
		this.oclass = oclass;
	}
	public int getFather_id() {
		return father_id;
	}
	public void setFather_id(int father_id) {
		this.father_id = father_id;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	
	

}
