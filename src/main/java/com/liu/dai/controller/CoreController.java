package com.liu.dai.controller;

import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import com.liu.dai.entity.event.QrCodeEvent;
import com.liu.dai.entity.in.BaseInMsg;
import com.liu.dai.entity.in.MsgType;
import com.liu.dai.exception.BussinessException;
import com.liu.dai.processor.ProcessorFactory;
import com.liu.dai.prop.WeixinProperty;
import com.liu.dai.util.InMsgParse;
import com.liu.dai.weixin.AesException;
import com.liu.dai.weixin.WXBizMsgCrypt;
import com.thoughtworks.xstream.XStream;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by liuyan9 on 2017/5/31.
 */
@Slf4j
@RestController
@RequestMapping("/core")
public class CoreController {

    @Autowired
    private WeixinProperty weixinProperty;

    @Autowired
    private HttpServletRequest httpServletRequest;

    @Autowired
    private HttpServletResponse httpServletResponse;

    @RequestMapping(method = RequestMethod.GET)
    public void core(@RequestParam String signature,
                     @RequestParam String timestamp, @RequestParam String nonce,
                     @RequestParam String echostr) {

        PrintWriter printWriter = null;
        try {
            printWriter = httpServletResponse.getWriter();
            printWriter.write(echostr);
        } catch (Exception e) {
            throw new BussinessException.DefaultException(e);
        } finally {
            if (printWriter != null) {
                printWriter.close();
            }
        }

    }


    @RequestMapping(method = RequestMethod.POST)
    public void post() {
        String msg = readInMsg(httpServletRequest);
        if (Strings.isNullOrEmpty(msg)) {
            throw new BussinessException.ResoveInMsgError();
        }
        BaseInMsg inMsg = InMsgParse.parse(msg);
        if (inMsg == null) {
            throw new BussinessException.UnKnowMsgTypeError();
        }

        ProcessorFactory.createProcessor(inMsg).process(inMsg, httpServletRequest, httpServletResponse);

    }

    private String readInMsg(HttpServletRequest httpServletRequest) {
        BufferedReader br = null;
        try {
            StringBuilder result = new StringBuilder();
            br = httpServletRequest.getReader();
            for (String line = null; (line = br.readLine()) != null; ) {
                result.append(line).append("\n");
            }
            return result.toString();
        } catch (IOException e) {
            throw new BussinessException.ResoveInMsgError(e);
        } finally {
            if (br != null)
                try {
                    br.close();
                } catch (IOException e) {
                    throw new BussinessException.ResoveInMsgError(e);
                }
        }
    }
}
