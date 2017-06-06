package com.liu.dai.exception;

import com.liu.dai.entity.BaseResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by liuyan9 on 2017/6/5.
 */
@Slf4j
@ControllerAdvice
public class WxExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(BussinessException.class)
    @ResponseBody
    BaseResult handleBadParameterException(HttpServletRequest httpServletRequest, BussinessException exception) {
        return handleExceptionInternal(exception);
    }

    private BaseResult handleExceptionInternal(BussinessException exception) {
        log.error(exception.getMessage(), exception);
        BaseResult baseResult = new BaseResult();
        baseResult.setErrcode(exception.getErrorCode());
        baseResult.setErrmsg(exception.getMessage());
        return baseResult;
    }
}
