package com.timber.eceiro.entity;


import io.rong.messages.BaseMessage;

public class SystemNoticeNoDisplayMessage  extends BaseMessage {
    /**
     * 文本消息
     */
    private String content;
    public static final transient String TYPE = "gtgxinspection:SysNoticeMsg";

    public SystemNoticeNoDisplayMessage() {}

    public void setContent(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }
    @Override
    public String getType() {
        return "gtgxinspection:SysNoticeMsg";
    }


    @Override
    public String toString() {
        return "SystemNoticeNoDisplayMessage{" + "content='" + content + '\'' + '}';
    }
}