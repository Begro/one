package com.liu.dai.processor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by liuyan9 on 2017/6/6.
 */
public interface IProcessor<T> {
    void process(T t, HttpServletRequest request, HttpServletResponse response);
}
