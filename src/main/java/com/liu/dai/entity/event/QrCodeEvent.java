package com.liu.dai.entity.event;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * Created by liuyan9 on 2017/6/6.
 * 扫描带参数二维码事件
 */
@Data
@Getter
@Setter
public class QrCodeEvent extends EventInMsg {
    private String eventKey;
    private String ticket;

    public QrCodeEvent(String ToUserName, String FromUserName, Integer CreateTime, String MsgType, String Event) {
        super(ToUserName, FromUserName, CreateTime, MsgType, Event);
    }
}
