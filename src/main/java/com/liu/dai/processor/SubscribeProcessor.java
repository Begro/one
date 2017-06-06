package com.liu.dai.processor;

import com.liu.dai.entity.event.SubscribeEvent;
import com.liu.dai.entity.out.TextMsg;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by liuyan9 on 2017/6/6.
 */
public class SubscribeProcessor extends AbstractProcessor implements IProcessor<SubscribeEvent> {
    private static final String content = "感谢关注刘研&代记婷的专属公众号";

    @Override
    public void process(SubscribeEvent subscribeEvent, HttpServletRequest request, HttpServletResponse response) {
        TextMsg textMsg = new TextMsg(subscribeEvent);
        textMsg.setContent(content);
        super.processText(textMsg, response);
    }
}
