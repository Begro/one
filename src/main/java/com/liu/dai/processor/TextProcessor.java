package com.liu.dai.processor;

import com.liu.dai.entity.in.InTextMsg;
import com.liu.dai.entity.out.TextMsg;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by liuyan9 on 2017/6/6.
 */
public class TextProcessor extends AbstractProcessor implements IProcessor<InTextMsg> {

    @Override
    public void process(InTextMsg inTextMsg, HttpServletRequest request, HttpServletResponse response) {

        String content = inTextMsg.getContent();
        String result = null;
        if ("代记婷".equalsIgnoreCase(content)) {
            result = "刘研";
        }
        if ("刘研".equalsIgnoreCase(content)) {
            result = "代记婷";
        }
        TextMsg textMsg = new TextMsg(inTextMsg);
        textMsg.setContent(result);
        super.processText(textMsg, response);
    }
}
