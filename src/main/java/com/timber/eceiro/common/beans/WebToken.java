package com.timber.eceiro.common.beans;

import org.springframework.stereotype.Component;

@Component
public class WebToken { 

    private String salt;//base64位签名
    private String name;//发行人名称
    private int expiresSecond;//保存时间

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getExpiresSecond() {
        return expiresSecond;
    }

    public void setExpiresSecond(int expiresSecond) {
        this.expiresSecond = expiresSecond;
    }

    @Override
    public String toString() {
        return "WebToken [salt=" + salt + ", name=" + name + ", expiresSecond=" + expiresSecond + "]";
    }

}