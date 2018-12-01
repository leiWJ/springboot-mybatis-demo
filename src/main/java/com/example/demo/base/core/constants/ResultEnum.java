package com.example.demo.base.core.constants;

/**
 * @author wen
 * @date 2018/1/22 14:37
 * @Description: 处理返回枚举类
 */
public enum ResultEnum {

    /**
     * 访问成功返回
     */
    SUCCESS(200, "success"),

    /**
     * 数据不存在返回
     */
    NOT_FOUND(404, "notFound [数据不存在 或者 数据为空]"),

    /**
     * 参数有异常返回
     */
    PARAMETER_ERROR(400, "parameter[参数异常:参数为空或者参数类型不符]"),

    /**
     * 权限验证失败
     */
    PERMISSIONS_ERROR(401, "permissions[签名错误，权限验证失败，访问被拒]"),

    /**
     * 异常返回
     */
    ERROR(-1, "[服务内部错误]"),

    /**
     * 参数有异常返回
     */
    DUPLICATE_ERROR(400, "Duplicate[参数异常:重复输入]"),

    /**
     * token生成异常
     */
    TOKENException(-1, "[token生成异常]"),

    /**
     * 空指针异常
     */
    NullPointerException(-1, "[空指针异常]"),
    /**
     * 下标越界异常
     */
    ArrayIndexOutOfBoundsException(-1, "[下标越界异常]"),
    /**
     * 输入输出异常
     */
    IOException(-1, "[IO文件上传异常]"),
    /**
     * 操作数据库异常
     */
    SQLException(-1, "[数据保存异常，请检查后重试！]"),
    /**
     * 类型强制转换异常
     */
    ClassCastException(-1, "[类型强制转换异常]"),
    /**
     * 文件未找到异常
     */
    FileNotFoundException(-1, "[文件未找到异常]"),
    /**
     * 字符串转换为数字异常
     */
    EOFException(-1, "[字符串转换为数字异常]"),
    /**
     * 文件已结束异常
     */
    NumberFormatException(-1, "[文件已结束异常]"),
    /**
     * 方法未找到异常
     */
    NoSuchMethodException(-1, "[方法未找到异常]"),
    /**
     * 参数类型匹配异常
     */
    MethodArgumentTypeMismatchException(-1, "[参数类型不匹配异常]"),
    /**
     * 文件上传异常
     */
    MultipartException(-1, "[文件上传异常]"),

    /**
     * 操作数据库异常
     */
    SQLFilterException(-1, "[SQL注入]异常"),

    NO_LOGIN(100, "[未登录或登录已过期]"),
    CONFIG_ERROR(101, "[参数配置表错误]"),
    USER_EXIST(102, "[用户名已存在]"),
    USERPWD_NOT_EXIST(403, "[用户名不存在或者密码错误]"),;
    private Integer code;

    private String msg;

    ResultEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
