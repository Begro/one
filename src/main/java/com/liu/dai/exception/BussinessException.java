package com.liu.dai.exception;

/**
 * Created by liuyan9 on 2017/6/5.
 */
public class BussinessException extends RuntimeException {


    private String errorCode;
    private static final String DEFAULT_ERROR = "E9999";
    private static final String RESOVE_IN_MSG_ERROR = "E0001";
    private static final String UN_KNOW_MSG_TYPE_ERROR = "E0002";

    public BussinessException(String errorcode, String errormsg, Throwable throwable) {
        super(errormsg, throwable);
        this.errorCode = errorcode;
    }

    public BussinessException(String errorcode, String errormsg) {
        super(errormsg);
        this.errorCode = errorcode;
    }

    public static class DefaultException extends BussinessException {
        public DefaultException(Throwable throwable) {
            super(DEFAULT_ERROR, "未知错误", throwable);
        }

        public DefaultException() {
            super(DEFAULT_ERROR, "未知错误");
        }
    }

    public static class ResoveInMsgError extends BussinessException {
        public ResoveInMsgError(Throwable throwable) {
            super(RESOVE_IN_MSG_ERROR, "解析数据失败", throwable);
        }

        public ResoveInMsgError() {
            super(RESOVE_IN_MSG_ERROR, "解析数据失败");
        }
    }


    public static class UnKnowMsgTypeError extends BussinessException {
        public UnKnowMsgTypeError(Throwable throwable) {
            super(UN_KNOW_MSG_TYPE_ERROR, "未知消息类型", throwable);
        }

        public UnKnowMsgTypeError() {
            super(UN_KNOW_MSG_TYPE_ERROR, "未知消息类型");
        }
    }

    public String getErrorCode() {
        return errorCode;
    }
}
