
package com.core.bin.user.config;

import com.core.bin.user.interceptor.UserInterceptor;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.ArrayList;
import java.util.List;


/**
 * @author wang
 * @date 2022-03-03 17:59
 */

@Configuration
@AllArgsConstructor
public class WebMvcConfig implements WebMvcConfigurer {

    private final UserInterceptor userInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //registry.addInterceptor(userInterceptor).addPathPatterns("/**").order(50).excludePathPatterns("/core/user/login");
    }

    public List<String> whiteList(){
        List<String> list = new ArrayList<>();
        list.add("/core/user/login");
        list.add("/core/user/register");
        return list;
    }

}

