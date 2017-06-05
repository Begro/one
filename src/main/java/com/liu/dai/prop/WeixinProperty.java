package com.liu.dai.prop;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * Created by liuyan9 on 2017/5/31.
 */
@Data
@Getter
@Setter
@Component
@Configuration
@ConfigurationProperties(prefix = "weixin")
@PropertySource("classpath:weixin.properties")
public class WeixinProperty {
    private String appid;
    private String secret;
    private String token;
    private String encodingAESKey;
}
