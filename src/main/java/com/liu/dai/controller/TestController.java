package com.liu.dai.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by liuyan9 on 2017/5/31.
 */
@RestController
public class TestController {

    @RequestMapping(value = "test",method = RequestMethod.GET)
    public void test(){

    }

}
