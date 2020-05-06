package com.timber.eceiro.common.utils;

public class CodeMsg {
	private int code;
	private String msg;
	// 按照模块定义CodeMsg
	// 通用异常
	public static CodeMsg SUCCESS = new CodeMsg(1000,"请求成功");
	public static CodeMsg TOKEN_FAILS = new CodeMsg(1001,"接口认证失败");
	public static CodeMsg  AUTH_EXPIRES= new CodeMsg(1002,"授权过期");
	public static CodeMsg  MISSING_PARAMETER= new CodeMsg(1003,"缺失参数");
	public static CodeMsg SERVER_EXCEPTION = new CodeMsg(1004,"网络异常");
	public static CodeMsg SERVER_ERROR = new CodeMsg(1009,"数据异常");
	public static CodeMsg USER_INFO_EXPIRES = new CodeMsg(1027,"用户信息过期");
	
	// 业务异常
	public static CodeMsg RONG_ERRAY = new CodeMsg(2000,"融云服务器异常");
	public static CodeMsg RONG_NOTICE_SEND_ERRAY = new CodeMsg(2001,"通知发送失败");
	public static CodeMsg WEATHER_ERRAY = new CodeMsg(2002,"天气接口异常");
	public static CodeMsg HUANGLI_ERRAY = new CodeMsg(2003,"黄历接口异常");

	public static CodeMsg MISSING_PATH = new CodeMsg(1020,"地址路径错误");

	public static CodeMsg OPERATE_ERROR = new CodeMsg(1022,"操作失败");
	public static CodeMsg ALREADY_SUBMIT = new CodeMsg(1023,"已经有人提交");
	public static CodeMsg ALREADY_COMPLETE = new CodeMsg(1024,"已完成");
	public static CodeMsg ALREADY_REPORT = new CodeMsg(1025,"监护已经上报");
	public static CodeMsg MIMSSING_AUTH = new CodeMsg(1026,"没有权限");





	private CodeMsg(int code, String msg) {
		this.code = code;
		this.msg = msg;
	}
	public int getCode() {
		return code;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
}
