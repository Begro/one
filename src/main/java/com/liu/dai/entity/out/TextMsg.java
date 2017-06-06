package com.liu.dai.entity.out;

import com.google.common.base.Preconditions;
import com.liu.dai.entity.in.BaseInMsg;
import lombok.Getter;
import lombok.Setter;

/**
 * Created by liuyan9 on 2017/6/6.
 */
@Getter
@Setter
public class TextMsg extends BaseOutMsg {

    private String content;

    public TextMsg(BaseInMsg inMsg) {
        super(inMsg);
        this.msgType = "text";
    }

    @Override
    protected void subXml(StringBuilder sb) {
        Preconditions.checkNotNull(sb);
        Preconditions.checkNotNull(content);
        sb.append("<Content><![CDATA[").append(content).append("]]></Content>\n");
    }
}
