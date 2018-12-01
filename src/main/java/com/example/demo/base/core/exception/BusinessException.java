package com.example.demo.base.core.exception;

/**
 * 业务层异常定义类
 *
 * @Author wen
 * @Date 2018/6/1
 */
public class BusinessException extends BaseException {
    private static final long serialVersionUID = 8566572900818858358L;

    public BusinessException() {
        super();
    }

    public BusinessException(int errorCode, String errorMsg) {
        super(errorCode, errorMsg);
    }

    public BusinessException(String errorMsg) {
        super(errorMsg);
    }

    public BusinessException(Throwable cause, int errorCode, String errorMsg) {
        super(cause, errorCode, errorMsg);
    }

    public BusinessException(Throwable cause, String errorMsg) {
        super(cause, errorMsg);
    }

    public BusinessException(Throwable cause) {
        super(cause);
    }
}
