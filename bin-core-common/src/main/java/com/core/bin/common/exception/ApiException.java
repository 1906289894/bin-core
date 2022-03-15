package com.core.bin.common.exception;

import com.core.bin.common.api.IError;

/**
 * @author wang
 * @date 2022-03-15 14:06
 */
public class ApiException extends RuntimeException {
    private IError error;

    public ApiException(IError error) {
        super(error.getMsg());
        this.error = error;
    }

    public ApiException(String msg) {
        super(msg);
    }

    public ApiException(Throwable cause) {
        super(cause);
    }

    public ApiException(String msg, Throwable cause) {
        super(msg, cause);
    }

    public IError getError() {
        return error;
    }
}
