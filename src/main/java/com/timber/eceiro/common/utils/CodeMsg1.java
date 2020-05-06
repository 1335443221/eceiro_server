package com.timber.eceiro.common.utils;

public class CodeMsg1 {
	private String code;
	private String msg;
	private int status;
	// 按照模块定义CodeMsg
	// 通用异常
	public static CodeMsg1 SUCCESS = new CodeMsg1("1000","OK",1);
	public static CodeMsg1 TOKEN_FAILS = new CodeMsg1("1001","token认证失败",0);
	public static CodeMsg1 AUTH_EXPIRES= new CodeMsg1("1002","授权过期",0);
	public static CodeMsg1 MISSING_PARAMETER= new CodeMsg1("1003","缺失参数",0);
	public static CodeMsg1 SERVER_EXCEPTION = new CodeMsg1("1004","网络异常",0);
	// 业务异常
	public static CodeMsg1 PW_INCORRECT = new CodeMsg1("1005","密码错误",0);
	public static CodeMsg1 MISSING_LOGIN_AUTH = new CodeMsg1("1006","没有登录权限",0);
	public static CodeMsg1 NOT_FIND_DATA = new CodeMsg1("1007","数据库无对应数据",0);
	public static CodeMsg1 MISSING_PATH = new CodeMsg1("1008","地址路径错误",0);
	public static CodeMsg1 SERVER_ERROR = new CodeMsg1("1009","数据异常",0);
	public static CodeMsg1 OPERATION_FAIL = new CodeMsg1("1010","操作失败",0);
	public static CodeMsg1 Data_Acquisition = new CodeMsg1("1011","数据获取异常",0);
	public static CodeMsg1 operating_Authorization  = new CodeMsg1("1012","没有操作权限",0);
	public static CodeMsg1 MISS_APPVERSION  = new CodeMsg1("1013","没有app版本",0);
	public static CodeMsg1 NAME_ALREADY_EXISTS= new CodeMsg1("1014","手机号已注册",0);
	public static CodeMsg1 PWD_FALSE= new CodeMsg1("1015","原密码不正确",0);
	public static CodeMsg1 Alarm_solved = new CodeMsg1("1016","报警已解决",0);
	public static CodeMsg1 Alarm_FAIL = new CodeMsg1("1017","报警处理失败",0);


	public CodeMsg1(String code, String msg, int status) {
		this.code = code;
		this.msg = msg;
		this.status = status;
	}
	public String getCode() {
		return code;
	}
	public String getMsg() {
		return msg;
	}
	public int getStatus(){return status;}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public void setStatus(int status){
		this.status = status;
	}
}
