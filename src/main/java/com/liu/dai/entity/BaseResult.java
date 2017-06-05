package com.liu.dai.entity;

import lombok.Data;
import lombok.extern.log4j.Log4j;

/**
 * Created by liuyan9 on 2017/6/5.
 */
@Log4j
@Data
public class BaseResult {
    private String errcode;
    private String errmsg;
}
