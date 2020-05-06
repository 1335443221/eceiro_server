package com.timber.eceiro.entity;

import java.io.Serializable;

public class VersionInfo implements Serializable{
	
	private int id;  //id
	private String version;  //版本号
	private String description;  //版本描述
	private String download_url;  //app下载地址
	private String is_force;  //是否强制更新（1：否；2：是）
	private String upload_at;  //上传时间
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getDownload_url() {
		return download_url;
	}
	public void setDownload_url(String download_url) {
		this.download_url = download_url;
	}
	public String getIs_force() {
		return is_force;
	}
	public void setIs_force(String is_force) {
		this.is_force = is_force;
	}
	public String getUpload_at() {
		return upload_at;
	}
	public void setUpload_at(String upload_at) {
		this.upload_at = upload_at;
	}


}
