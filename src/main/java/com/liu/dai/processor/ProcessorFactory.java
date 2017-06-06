package com.liu.dai.processor;

import com.google.common.base.Preconditions;
import com.liu.dai.entity.event.QrCodeEvent;
import com.liu.dai.entity.event.SubscribeEvent;
import com.liu.dai.entity.in.BaseInMsg;
import com.liu.dai.exception.BussinessException;

/**
 * Created by liuyan9 on 2017/6/6.
 */
public class ProcessorFactory {

    private ProcessorFactory() {
    }

    public static IProcessor createProcessor(BaseInMsg inMsg) {
        Preconditions.checkNotNull(inMsg);
        if (inMsg instanceof QrCodeEvent) {
            return new QrEventProcessor();
        } else if (inMsg instanceof SubscribeEvent) {
            return new SubscribeProcessor();
        } else {
            throw new BussinessException.UnKnowMsgTypeError();
        }
    }

}
