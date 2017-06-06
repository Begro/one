package com.liu.dai.entity.event;

/**
 * Created by liuyan9 on 2017/6/5.
 */
public enum EventType {
    关注("subscribe"), 取消关注("unsubscribe");

    private String code;

    EventType(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}
