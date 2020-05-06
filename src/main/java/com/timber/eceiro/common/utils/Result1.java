package com.timber.eceiro.common.utils;

public class Result1<T> {
	private String msg;
	private String code;
	private T data;
	private int status;
	private int rid;
	public Result1(T data,int rid) {
		this.code = "1000";
		this.msg = "OK";
		this.data = data;
		this.status=1;
		this.rid=rid;
	}

	public Result1(T data) {
		this.code = "1000";
		this.msg = "OK";
		this.data = data;
		this.status=1;
	}

	public Result1(int rid) {
		this.code = "1005";
		this.msg = "当前列表为空";
		this.status=1;
		this.rid=rid;
	}

	public Result1(String code, String msg,int rid){
		this.code = code;
		this.msg = msg;
		this.data = null;
		this.status=0;
		this.rid=rid;
	}
	public Result1(String code, String msg){
		this.code = code;
		this.msg = msg;
		this.data = null;
		this.status=0;
	}

	public Result1(String code, T data, String msg,int rid){
		this.code = code;
		this.msg = msg;
		this.data = data;
		this.status=0;
		this.rid=rid;
	}

	public Result1(String code, T data, String msg){
		this.code = code;
		this.msg = msg;
		this.data = data;
		this.status=0;
	}

	private Result1(CodeMsg1 cm,int rid) {
		if(cm == null){
			return;
		}
		this.code = cm.getCode();
		this.msg = cm.getMsg();
		this.status=cm.getStatus();
		this.rid=rid;
	}
	/**
	 * 成功时候的调用
	 * @return
	 */
	public static <T> Result1<T> success(T data,int rid){
		return new Result1<T>(data,rid);
	}
	/**
	 * 成功，不需要传入参数
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static <T> Result1<T> success(int rid){
		return (Result1<T>) success("",rid);
	}
	/**
	 * 失败时候的调用
	 * @return
	 */
	public static <T> Result1<T> error(CodeMsg1 cm,int rid){
		return new Result1<T>(cm,rid);
	}
	/**
	 * 失败时候的调用,扩展消息参数
	 * @param cm
	 * @param msg
	 * @return
	 */
	public static <T> Result1<T> error(CodeMsg1 cm, String msg,int rid){
		cm.setMsg(cm.getMsg()+"--"+msg);
		return new Result1<T>(cm,rid);
	}
	public T getData() {
		return data;
	}
	public String getMsg() {
		return msg;
	}
	public String getCode() {
		return code;
	}
	public int getStatus(){
		return status;
	}
	public int getRid(){
		return rid;
	}
}
