package com.timber.eceiro.entity;


import io.rong.messages.BaseMessage;

public class GroupNotificationMessage extends BaseMessage {
    public static final transient String TYPE = "RC:GrpNtf";

    private static final String TAG = "GroupNotificationMessage";
    public static final String GROUP_OPERATION_CREATE = "Create";
    public static final String GROUP_OPERATION_ADD = "Add";
    public static final String GROUP_OPERATION_DISMISS = "Dismiss";
    public static final String GROUP_OPERATION_QUIT = "Quit";
    public static final String GROUP_OPERATION_KICKED = "Kicked";
    public static final String GROUP_OPERATION_RENAME = "Rename";
    public static final String GROUP_OPERATION_BULLETIN = "Bulletin";
    private String operatorUserId;
    private String extra;
    private String operation;
    private String data;
    private String message;


    public GroupNotificationMessage(String operatorUserId,String operation, String data) {
        this.operatorUserId = operatorUserId;
        this.operation = operation;
        this.data = data;
    }


    public String getOperatorUserId() {
        return operatorUserId;
    }

    public void setOperatorUserId(String operatorUserId) {
        this.operatorUserId = operatorUserId;
    }

    public String getExtra() {
        return extra;
    }

    public void setExtra(String extra) {
        this.extra = extra;
    }

    public String getData() {
        return data;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }
    public String getOperation() {
        return operation;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }




    @Override
    public String getType() {
        return "RC:GrpNtf";
    }
    @Override
    public String toString() {
        return "GroupNotificationMessage{" + "content='" + '\'' + '}';
    }
}