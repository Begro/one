package com.liu.dai.entity.event;

import com.liu.dai.entity.in.BaseInMsg;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * Created by liuyan9 on 2017/6/5.
 */
@Data
@Getter
@Setter
public abstract class EventInMsg extends BaseInMsg {

    private String event;

    public EventInMsg(String toUserName, String fromUserName, Integer createTime, String msgType, String event) {
        super(toUserName, fromUserName, createTime, msgType);
        this.event = event;
    }
}
