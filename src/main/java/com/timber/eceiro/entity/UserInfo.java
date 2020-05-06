package com.timber.eceiro.entity;

import java.io.Serializable;
import java.text.SimpleDateFormat;

public class UserInfo implements Serializable{
	
	private static final long serialVersionUID = -4943616807884763256L;
	private int id;  //id
	private String job_number;  //工号
	private String login_name;  //登录名
	private String user_name;  //姓名
	private String email;  //邮箱
	private String phone;  //电话
	private String cellphone;  //电话
	private String password;  //密码
	private String portrait;  //头像
	private long create_at;  //创建时间
	private long update_at;  //更新时间
	private int allow_login;  //是否允许登录（1：是；2：否）
	private int is_delete;   //是否已删除（1：是；2：否）
	private String rong_token;   //是否已删除（1：是；2：否）
	private int company_id;   //是否已删除（1：是；2：否）
	
	private RoleInfo roleInfo;
	private Organization organization;
	
	private String createTime;  //格式化创建时间

	
	
	public int getCompany_id() {
		return company_id;
	}
	public void setCompany_id(int company_id) {
		this.company_id = company_id;
	}
	public String getRong_token() {
		return rong_token;
	}
	public void setRong_token(String rong_token) {
		this.rong_token = rong_token;
	}
	public int getAllow_login() {
		return allow_login;
	}
	public void setAllow_login(int allow_login) {
		this.allow_login = allow_login;
	}
	public int getIs_delete() {
		return is_delete;
	}
	public void setIs_delete(int is_delete) {
		this.is_delete = is_delete;
	}
	public String getCreateTime() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");   //把时间转换成年月日
		return sdf.format(create_at*1000);
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getJob_number() {
		return job_number;
	}
	public void setJob_number(String job_number) {
		this.job_number = job_number;
	}
	public String getLogin_name() {
		return login_name;
	}
	public void setLogin_name(String login_name) {
		this.login_name = login_name;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getCellphone() {
		return cellphone;
	}
	public void setCellphone(String cellphone) {
		this.cellphone = cellphone;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPortrait() {
		return portrait;
	}
	public void setPortrait(String portrait) {
		this.portrait = portrait;
	}
	
	public long getCreate_at() {
		return create_at;
	}
	public void setCreate_at(long create_at) {
		this.create_at = create_at;
	}
	public long getUpdate_at() {
		return update_at;
	}
	public void setUpdate_at(long update_at) {
		this.update_at = update_at;
	}
	public void setUpdate_at(int update_at) {
		this.update_at = update_at;
	}
	public RoleInfo getRoleInfo() {
		return roleInfo;
	}
	public void setRoleInfo(RoleInfo roleInfo) {
		this.roleInfo = roleInfo;
	}
	public Organization getOrganization() {
		return organization;
	}
	public void setOrganization(Organization organization) {
		this.organization = organization;
	}
	
	

	
}
