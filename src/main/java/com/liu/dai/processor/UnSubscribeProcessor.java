package com.liu.dai.processor;

import com.liu.dai.entity.event.SubscribeEvent;
import com.liu.dai.entity.out.TextMsg;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by liuyan9 on 2017/6/6.
 */
public class UnSubscribeProcessor extends AbstractProcessor implements IProcessor<SubscribeEvent> {

    @Override
    public void process(SubscribeEvent subscribeEvent, HttpServletRequest request, HttpServletResponse response) {
    }
}
