package com.timber.eceiro.entity;

import java.io.Serializable;
import java.text.SimpleDateFormat;

public class Patrol_Log implements Serializable{
	private int id;  //id
	private PatrolInfo patrolInfo;  //巡检id
	private int status;  //巡检状态（1：未巡检；2：已巡检）
	private UserInfo patrolUserInfo;  //巡检人
	private long first_clock_at;  //第一次打卡时间
	private long second_clock_at;  //第二次打卡时间

	private int malcount;  //故障次数；
	private String time;      //当天日期
	private String first_clock_at1;  //第一次打卡时间
	private String second_clock_at1;  //第二次打卡时间



	public int getMalcount() {
		return malcount;
	}
	public void setMalcount(int malcount) {
		this.malcount = malcount;
	}
	public String getTime() {
	if(first_clock_at==0){
		return "今天未打卡";
	}else{
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");   //把时间转换成年月日
		return sdf.format(first_clock_at*1000);
	}}
	public void setTime(String time) {
		this.time = time;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public PatrolInfo getPatrolInfo() {
		return patrolInfo;
	}
	public void setPatrolInfo(PatrolInfo patrolInfo) {
		this.patrolInfo = patrolInfo;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}

	public UserInfo getPatrolUserInfo() {
		return patrolUserInfo;
	}
	public void setPatrolUserInfo(UserInfo patrolUserInfo) {
		this.patrolUserInfo = patrolUserInfo;
	}
	public long getFirst_clock_at() {
		return first_clock_at;
	}
	public void setFirst_clock_at(long first_clock_at) {
		this.first_clock_at = first_clock_at;
	}
	public long getSecond_clock_at() {
		return second_clock_at;
	}
	public void setSecond_clock_at(long second_clock_at) {
		this.second_clock_at = second_clock_at;
	}
	
	public String getFirst_clock_at1() {
		if(first_clock_at==0){
			return "未打卡";
		}else{
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
		return sdf.format(first_clock_at*1000);
	}}
	public void setFirst_clock_at1(String first_clock_at1) {
		this.first_clock_at1 = first_clock_at1;
	}
	public String getSecond_clock_at1() {
		if(second_clock_at==0){
			return "没有第二次打卡";
		}else{
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
			return sdf.format(second_clock_at*1000);
		}
		
	}
	public void setSecond_clock_at1(String second_clock_at1) {
		this.second_clock_at1 = second_clock_at1;
	}
	
	
	
	

	
	
	

}
