package com.example.demo.base;


import com.example.demo.base.core.constants.CodeConstant;

public class ResultUtil {

    //返回成功
    public static Result getSuccessJson() {
        Result result = new Result();
        result.setCode(CodeConstant.Success.getCode());
        result.setMessage(CodeConstant.Success.getMsg());
        return result;
    }

    //返回成功
    public static Result getSuccessJson(Object result) {
        Result jsonResult = new Result();
        jsonResult.setCode(CodeConstant.Success.getCode());
        jsonResult.setMessage(CodeConstant.Success.getMsg());
        jsonResult.setData(result);
        return jsonResult;
    }

    //失败
    public static Result getErrorJson() {
        Result jsonResult = new Result();
        jsonResult.setCode(CodeConstant.Error.getCode());
        jsonResult.setMessage(CodeConstant.Error.getMsg());
        return jsonResult;
    }

    //各种code返回
    public static Result getCommonJson(int code, String msg) {
        Result jsonResult = new Result();
        jsonResult.setCode(code);
        jsonResult.setMessage(msg);
        return jsonResult;
    }

    //返回成功
    public static Result getSuccessJson(String msg, Object result) {
        Result jsonResult = new Result();
        jsonResult.setCode(CodeConstant.Success.getCode());
        jsonResult.setMessage(msg);
        jsonResult.setData(result);
        return jsonResult;
    }

    //失败
    public static Result getErrorJson(String msg) {
        Result result = new Result();
        result.setCode(CodeConstant.Error.getCode());
        result.setMessage(msg);
        return result;
    }

    //返回成功
    public static Result getNotFoundJson() {
        Result result = new Result();
        result.setCode(CodeConstant.NotFound.getCode());
        result.setMessage(CodeConstant.NotFound.getMsg());
        return result;
    }

}
