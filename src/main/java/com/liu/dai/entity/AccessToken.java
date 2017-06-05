package com.liu.dai.entity;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

/**
 * Created by liuyan9 on 2017/6/5.
 */
@Slf4j
@Data
public final class AccessToken extends BaseResult {
    private String access_token;
    private String expires_in;
}
