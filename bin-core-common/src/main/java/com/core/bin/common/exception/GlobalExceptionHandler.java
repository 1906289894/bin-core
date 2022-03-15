package com.core.bin.common.exception;

import com.core.bin.common.api.CommonResult;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletResponse;
import java.util.Objects;

/**
 * @author wang
 * @description: 全局异常处理
 * @date 2022-03-15 15:12
 */
@RestControllerAdvice
@AllArgsConstructor
public class GlobalExceptionHandler {
    private final HttpServletResponse response;

    @ExceptionHandler(value = Exception.class)
    public CommonResult<String> handleException(Exception e) {
        response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        return CommonResult.failed(e.getMessage());
    }

    @ExceptionHandler(value = ApiException.class)
    public CommonResult<Void> handle(ApiException e) {
        response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        if (Objects.nonNull(e.getError())) {
            return CommonResult.failed(e.getError());
        }
        return CommonResult.failed(e.getMessage());
    }

    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public CommonResult<Void> handleValidException(MethodArgumentNotValidException e) {
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        BindingResult bindingResult = e.getBindingResult();
        String msg = null;
        if (bindingResult.hasErrors()) {
            FieldError fieldError = bindingResult.getFieldError();
            if (Objects.nonNull(fieldError)) {
                msg = fieldError.getField() + ":" + fieldError.getDefaultMessage();
            }
        }
        return CommonResult.validateFailed(msg);
    }

    @ExceptionHandler(value = BindException.class)
    public CommonResult<Void> handleValidException(BindException e) {
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        BindingResult bindingResult = e.getBindingResult();
        String message = null;
        if (bindingResult.hasErrors()) {
            FieldError fieldError = bindingResult.getFieldError();
            if (fieldError != null) {
                message = fieldError.getField() + ":" + fieldError.getDefaultMessage();
            }
        }
        return CommonResult.validateFailed(message);
    }
}
