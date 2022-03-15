package com.core.bin.common.api;

/**
 * @author wang
 * @description: 常用返回对象
 * @date 2022-03-15 15:21
 */
public enum ResultCode implements IError {
    SUCCESS(200, "操作成功"),
    FAILED(500, "操作失败"),
    VALIDATE_FAILED(404, "参数校验失败"),
    UNAUTHORIZED(401, "暂未登录或token无效"),
    FORBIDDEN(403, "没有相关权限");
    private long code;
    private String msg;

    @Override
    public long getCode() {
        return code;
    }

    ResultCode(long code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    @Override
    public String getMsg() {
        return msg;
    }
}
