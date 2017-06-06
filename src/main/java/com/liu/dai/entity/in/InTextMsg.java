package com.liu.dai.entity.in;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by liuyan9 on 2017/6/6.
 */
@Getter
@Setter
public class InTextMsg extends BaseInMsg {
    private String msgId;
    private String content;

    public InTextMsg(String toUserName, String fromUserName, Integer createTime, String msgType) {
        super(toUserName, fromUserName, createTime, msgType);
    }
}
