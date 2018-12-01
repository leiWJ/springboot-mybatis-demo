package com.example.demo.base.core.constants;


/**
 * 返回代码枚举
 *
 * @author wen
 * @date 2018/6/1
 */
public enum CodeConstant {

    Success(0, "成功"),
    Error(-1, "失败"),
    NotFound(404, "数据为空");

    private int code;

    private String msg;

    CodeConstant(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
