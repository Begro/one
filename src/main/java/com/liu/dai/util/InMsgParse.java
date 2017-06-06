package com.liu.dai.util;

import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import com.liu.dai.entity.event.*;
import com.liu.dai.entity.in.BaseInMsg;
import com.liu.dai.entity.in.InTextMsg;
import com.liu.dai.entity.in.MsgType;

/**
 * Created by liuyan9 on 2017/6/6.
 */
public class InMsgParse {

    private InMsgParse() {
    }


    public static BaseInMsg parse(String xml) {
        Preconditions.checkNotNull(xml);
        XmlHelper xmlHelper = XmlHelper.newInstance(xml);
        return doParse(xmlHelper);
    }


    private static BaseInMsg doParse(XmlHelper xmlHelper) {
        String toUserName = xmlHelper.getString("//ToUserName");
        String fromUserName = xmlHelper.getString("//FromUserName");
        Integer createTime = xmlHelper.getNumber("//CreateTime").intValue();
        String msgType = xmlHelper.getString("//MsgType");
        if (MsgType.事件.getCode().equalsIgnoreCase(msgType)) {
            return parseEvent(xmlHelper, toUserName, fromUserName, createTime, msgType);
        } else if (MsgType.文本.getCode().equalsIgnoreCase(msgType)) {
            return parseText(xmlHelper, toUserName, fromUserName, createTime, msgType);
        } else {
            return null;
        }
    }

    private static BaseInMsg parseText(XmlHelper xmlHelper, String toUserName, String fromUserName, Integer createTime, String msgType) {
        String msgId = xmlHelper.getString("//MsgId");
        String content = xmlHelper.getString("//Content");
        InTextMsg inTextMsg = new InTextMsg(toUserName, fromUserName, createTime, msgType);
        inTextMsg.setContent(content);
        inTextMsg.setMsgId(msgId);
        return inTextMsg;
    }

    private static BaseInMsg parseEvent(XmlHelper xmlHelper, String toUserName, String fromUserName, Integer createTime, String msgType) {
        String event = xmlHelper.getString("//Event");
        String eventKey = xmlHelper.getString("//EventKey");
        //取消关注事件
        if (EventType.取消关注.getCode().equalsIgnoreCase(event)) {
            return new UnSubscribeEvent(toUserName, fromUserName, createTime, msgType, event);
        }
        String ticket = xmlHelper.getString("//Ticket");
        //未关注用户扫码事件
        if (EventType.关注.getCode().equals(event) && !Strings.isNullOrEmpty(eventKey) && eventKey.startsWith("qrscene_")) {
            QrCodeEvent qrCodeEvent = new QrCodeEvent(toUserName, fromUserName, createTime, msgType, event);
            qrCodeEvent.setEventKey(eventKey);
            qrCodeEvent.setTicket(ticket);
            return qrCodeEvent;
        } else if (EventType.关注.getCode().equals(event)) {
            SubscribeEvent subscribeEvent = new SubscribeEvent(toUserName, fromUserName, createTime, msgType, event);
            return subscribeEvent;
        } else {
            return null;
        }
    }

}
