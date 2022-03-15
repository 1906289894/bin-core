package com.core.bin.common.exception;

import com.core.bin.common.api.IError;

/**
 * @author wang
 * @description: 断言处理类
 * @date 2022-03-15 15:09
 */
public class Asserts {

    public static void fail(String msg) {
        throw new ApiException(msg);
    }

    public static void fail(IError error) {
        throw new ApiException(error);
    }
}
