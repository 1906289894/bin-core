package com.core.bin.user.interceptor;

import com.core.bin.common.exception.ApiException;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author wang
 * @date 2022-03-03 17:58
 */
@Component
public class UserInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler){
        String author = response.getHeader("auth");
        if (StringUtils.isEmpty("")) {
            throw new ApiException("亲，请登录");
        }
        return true;
    }
}
