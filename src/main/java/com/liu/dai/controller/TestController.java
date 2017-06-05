package com.liu.dai.controller;

import com.liu.dai.prop.WeixinProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by liuyan9 on 2017/5/31.
 */
@RestController
public class TestController {

    @Autowired
    private WeixinProperty weixinProperty;

    @RequestMapping(value = "test", method = RequestMethod.GET)
    public void test() {
        weixinProperty.getAppid();
    }

}
