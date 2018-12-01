
package com.example.demo.base;

/**
 * 通用返回对象
 * @author JOHN
 * @date 2018/4/26
 */
public class Result<T> {
	/*
	 * 0 成功 -1 失败
	 */
	private int code;
	/*
	 * 请求结果信息
	 */
    private String message;

    private T data;

    public Result(Integer code, String message) {
        this.code = code;
        this.message = message;
    }


    public Result(Integer code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public Result() {

    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
