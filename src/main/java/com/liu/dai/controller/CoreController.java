package com.liu.dai.controller;

import com.liu.dai.prop.WeixinProperty;
import com.liu.dai.weixin.AesException;
import com.liu.dai.weixin.WXBizMsgCrypt;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
                     @RequestParam String echostr) throws AesException, IOException {

        PrintWriter printWriter = null;
        try {
            printWriter = httpServletResponse.getWriter();
            printWriter.write(echostr);
        } catch (IOException e) {
            log.error(e.getMessage(), e);
            throw e;
        } finally {
            if (printWriter != null) {
                printWriter.close();
            }
        }

    }
}
