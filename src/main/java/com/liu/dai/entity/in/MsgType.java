package com.liu.dai.entity.in;

/**
 * Created by liuyan9 on 2017/6/5.
 */
public enum MsgType {
    文本("text"), 事件("event");

    private String code;

    MsgType(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}
