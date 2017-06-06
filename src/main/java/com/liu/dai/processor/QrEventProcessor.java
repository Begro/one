package com.liu.dai.processor;

import com.liu.dai.entity.event.QrCodeEvent;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by liuyan9 on 2017/6/6.
 */
public class QrEventProcessor extends AbstractProcessor implements IProcessor<QrCodeEvent> {

    @Override
    public void process(QrCodeEvent qrCodeEvent, HttpServletRequest request, HttpServletResponse response) {
    }
}
