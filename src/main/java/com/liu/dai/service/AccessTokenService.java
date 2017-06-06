package com.liu.dai.service;

import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.liu.dai.entity.AccessToken;
import com.liu.dai.prop.WeixinApi;
import com.liu.dai.prop.WeixinProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/**
 * Created by liuyan9 on 2017/6/5.
 */
@Service
@Slf4j
public class AccessTokenService {

    private static final int EXPIRE = 7100;

    private static final String CACHE_KEY = "token";
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private WeixinProperty weixinProperty;

    private static LoadingCache<String, String> tokenCache;

    static {
        tokenCache = CacheBuilder.newBuilder().expireAfterWrite(EXPIRE, TimeUnit.SECONDS)
                .build(new CacheLoader<String, String>() {
                    @Override
                    public String load(String s) throws Exception {
                        return createExpensiveGraph(s);
                    }
                });
    }

    private static String createExpensiveGraph(String key) {
        return "";
    }


    public String getAccessToken() {
        try {
            String accessToken = tokenCache.get(CACHE_KEY);
            if (Strings.isNullOrEmpty(accessToken)) {
                String appid = weixinProperty.getAppid();
                String secret = weixinProperty.getSecret();
                String url = String.format(WeixinApi.ACDESS_TOKEN, appid, secret);
                AccessToken token = restTemplate.postForObject(url, null, AccessToken.class);
                Preconditions.checkArgument(!Strings.isNullOrEmpty(token.getAccess_token()), token.getErrmsg());
                accessToken = token.getAccess_token();
                tokenCache.put(CACHE_KEY, accessToken);
            }
            return accessToken;
        } catch (ExecutionException e) {
            log.error(e.getMessage(), e);
            throw new RuntimeException(e);
        }
    }
}
