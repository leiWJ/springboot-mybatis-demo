package com.example.demo.base.core.exception;

import java.io.PrintStream;
import java.io.PrintWriter;

/**
 * 自定义异常基础类
 *
 * @Author wen
 * @Date 2018/6/1
 */
public class BaseException extends RuntimeException {
    private static final long serialVersionUID = -434104233779192938L;
    /**
     * 未知错误code
     */
    public static final int UNKNOWN_ERROR_CODE = -1;
    /**
     * 未知错误message=""
     */
    public static final String UNKNOWN_ERROR_MSG = "失败";

    private Throwable cause;//异常
    private int errorCode;//错误code

    public BaseException() {
        this(BaseException.UNKNOWN_ERROR_CODE, BaseException.UNKNOWN_ERROR_MSG);
    }

    public BaseException(String errorMsg) {
        this(null, errorMsg);
    }

    public BaseException(Throwable cause) {
        this(cause, "");
    }

    public BaseException(int errorCode, String errorMsg) {
        this(null, errorCode, errorMsg);
    }

    public BaseException(Throwable cause, String errorMsg) {
        this(cause, BaseException.UNKNOWN_ERROR_CODE, errorMsg);
    }

    public BaseException(Throwable cause, int errorCode, String errorMsg) {
        super(errorMsg);
        this.cause = cause;
        this.errorCode = errorCode;
    }

    public void printStackTrace() {
        this.printStackTrace(System.err);
    }

    public void printStackTrace(PrintStream ps) {
        if (null == getCause()) {
            super.printStackTrace(ps);
        } else {
            ps.println(this);
            getCause().printStackTrace(ps);
        }
    }

    public void printStackTrace(PrintWriter pw) {
        if (null == getCause()) {
            super.printStackTrace(pw);
        } else {
            pw.println(this);
            getCause().printStackTrace(pw);
        }
    }

    public Throwable getCause() {
        return this.cause == this ? null : this.cause;
    }

    public String getMessage() {
        if (getCause() == null) {
            return super.getMessage();
        }
        return super.getMessage() + getCause().getMessage();
    }

    public int getErrorCode() {
        return errorCode;
    }
}
