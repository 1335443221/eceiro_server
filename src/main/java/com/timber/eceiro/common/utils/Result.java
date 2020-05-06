package com.timber.eceiro.common.utils;

public class Result<T> {
	private String msg;
	private int code;
	private T data;
	private int rid;
	private Result(T data) {
		this.code = 1000;
		this.msg = "请求成功";
		this.data = data;
	}
	private Result(CodeMsg cm) {
		if(cm == null){
			return;
		}
		this.code = cm.getCode();
		this.msg = cm.getMsg();
	}
	private Result(CodeMsg cm,int rid) {
		if(cm == null){
			return;
		}
		this.code = cm.getCode();
		this.msg = cm.getMsg();
		this.rid=rid;
	}
	/**
	 * 成功时候的调用
	 * @return
	 */
	public static <T> Result<T> success(T data){
		return new Result<T>(data);
	}
	/**
	 * 成功，不需要传入参数
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static <T> Result<T> success(CodeMsg cm,int rid){
		return new Result<T>(cm,rid);
	}
	/**
	 * 失败时候的调用
	 * @return
	 */
	public static <T> Result<T> error(CodeMsg cm,int rid){
		return new Result<T>(cm,rid);
	}
	/**
	 * 失败时候的调用,扩展消息参数
	 * @param cm
	 * @param msg
	 * @return
	 */
	public static <T> Result<T> error(CodeMsg cm,String msg){
		cm.setMsg(cm.getMsg()+"--"+msg);
		return new Result<T>(cm);
	}
	public T getData() {
		return data;
	}
	public String getMsg() {
		return msg;
	}
	public int getCode() {
		return code;
	}

	public int getRid() {
		return rid;
	}

	public void setRid(int rid) {
		this.rid = rid;
	}
}
