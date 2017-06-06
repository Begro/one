package com.liu.dai.processor;

import com.liu.dai.entity.event.SubscribeEvent;
import com.liu.dai.entity.event.UnSubscribeEvent;
import com.liu.dai.entity.out.TextMsg;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by liuyan9 on 2017/6/6.
 */
public class UnSubscribeProcessor extends AbstractProcessor implements IProcessor<UnSubscribeEvent> {

    @Override
    public void process(UnSubscribeEvent unSubscribeEvent, HttpServletRequest request, HttpServletResponse response) {
    }
}
