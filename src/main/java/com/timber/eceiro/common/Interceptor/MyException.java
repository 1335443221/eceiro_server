package com.timber.eceiro.common.Interceptor;

import com.timber.eceiro.common.utils.CodeMsg;
import org.apache.log4j.Logger;

public class MyException extends RuntimeException {

    private static final long serialVersionUID = 1L;
    private Logger logger = Logger.getLogger(getClass());

    CodeMsg cm;
    private int code;
    private String msg;
    private String info;
    private int rid;

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public MyException() {}

    public MyException(int i, String msg,int rid) {
        this.code = i;
        this.msg = msg;
        this.rid = rid;
    }

    public MyException(CodeMsg cm,int rid) {
        this.code = cm.getCode();
        this.msg = cm.getMsg();
        this.rid = rid;
    }
    public MyException(int i, String msg, String info) {
        this.code = i;
        this.msg = msg;
        this.info = info;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getRid() {
        return rid;
    }

    public void setRid(int rid) {
        this.rid = rid;
    }

    public CodeMsg getCm() {
        return cm;
    }

    public void setCm(CodeMsg cm) {
        this.cm = cm;
    }

    @Override
    public String toString() {
        return "MyException{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", info='" + info + '\'' +
                ", rid='" + rid + '\'' +
                '}';
    }
}
