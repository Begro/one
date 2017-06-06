package com.liu.dai.entity.out;

import com.liu.dai.entity.in.BaseInMsg;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * Created by liuyan9 on 2017/6/6.
 */
@Getter
@Setter
public abstract class BaseOutMsg {
    protected String toUserName;

    protected String fromUserName;

    protected Integer createTime;

    protected String msgType;

    public BaseOutMsg(BaseInMsg inMsg) {
        this.toUserName = inMsg.getFromUserName();
        this.fromUserName = inMsg.getToUserName();
        this.createTime = now();
    }

    public String toXml() {
        StringBuilder sb = new StringBuilder();
        sb.append("<xml>\n");
        sb.append("<ToUserName><![CDATA[").append(toUserName).append("]]></ToUserName>\n");
        sb.append("<FromUserName><![CDATA[").append(fromUserName).append("]]></FromUserName>\n");
        sb.append("<CreateTime>").append(createTime).append("</CreateTime>\n");
        sb.append("<MsgType><![CDATA[").append(msgType).append("]]></MsgType>\n");
        subXml(sb);
        sb.append("</xml>");
        return sb.toString();
    }

    protected abstract void subXml(StringBuilder sb);

    public Integer now() {
        return (int) (System.currentTimeMillis() / 1000);
    }
}
