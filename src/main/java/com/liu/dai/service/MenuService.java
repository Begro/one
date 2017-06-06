package com.liu.dai.service;

import com.liu.dai.entity.BaseResult;
import com.liu.dai.entity.menu.Button;
import com.liu.dai.entity.menu.ClickButton;
import com.liu.dai.entity.menu.Menu;
import com.liu.dai.prop.WeixinApi;
import com.liu.dai.prop.WeixinProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * Created by liuyan9 on 2017/6/6.
 */
@Service
public class MenuService {
    @Autowired
    private WeixinProperty weixinProperty;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private AccessTokenService accessTokenService;

    public void create() {
        Menu menu = new Menu();
        ClickButton clickButton = new ClickButton();
        clickButton.setName("测试");
        clickButton.setKey("test");
        menu.getButton().add(clickButton);
        String token = accessTokenService.getAccessToken();
        BaseResult baseResult = restTemplate.postForObject(String.format(WeixinApi.CREATE_MENU, token), menu, BaseResult.class);
        if ("0".equalsIgnoreCase(baseResult.getErrcode())) {
            System.out.println("上传成功");
        } else {
            System.out.println(baseResult.getErrmsg());
        }
    }
}
