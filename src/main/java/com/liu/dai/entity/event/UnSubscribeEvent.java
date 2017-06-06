package com.liu.dai.entity.event;

/**
 * Created by liuyan9 on 2017/6/5.
 */
public class UnSubscribeEvent extends EventInMsg {

    public UnSubscribeEvent(String toUserName, String fromUserName, Integer createTime, String msgType, String event) {
        super(toUserName, fromUserName, createTime, msgType, event);
    }
}
