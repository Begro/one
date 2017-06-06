package com.liu.dai.controller;

import com.liu.dai.exception.BussinessException;
import com.liu.dai.prop.WeixinProperty;
import com.liu.dai.service.AccessTokenService;
import com.liu.dai.service.MenuService;
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

    @Autowired
    private MenuService menuService;

    @RequestMapping(value = "test", method = RequestMethod.GET)
    public void test() {
        menuService.create();
    }

}
