package com.hsbc.exception;

/**
 * 基础自定义业务异常
 *
 * @author zhonghuashishan
 * @version 1.0
 */
public class BaseBizException extends RuntimeException {

    /**
     * 默认错误码
     */
    private static final Integer DEFAULT_ERROR_CODE = 500;

    private Integer errorCode;

    private String errorMsg;

    public BaseBizException(String errorMsg) {
        super(errorMsg);
        this.errorCode = DEFAULT_ERROR_CODE;
        this.errorMsg = errorMsg;
    }

    public BaseBizException(Integer errorCode, String errorMsg) {
        super(errorMsg);
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
    }

    public Integer getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(Integer errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }
}