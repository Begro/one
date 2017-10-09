package com.liu.dai.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 * Created by liuyan9 on 2017/6/5.
 */
@Slf4j
@ControllerAdvice
public class WxExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(BussinessException.class)
    @ResponseBody
    void handlerException(BussinessException exception) {
        handleExceptionInternal(exception);
    }

    private void handleExceptionInternal(BussinessException exception) {
        log.error(exception.getMessage(), exception);
//        BaseResult baseResult = new BaseResult();
//        baseResult.setErrcode(exception.getErrorCode());
//        baseResult.setErrmsg(exception.getMessage());
//        return baseResult;
    }
}
