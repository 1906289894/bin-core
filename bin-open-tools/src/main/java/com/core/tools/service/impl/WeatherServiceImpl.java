package com.core.tools.service.impl;

import cn.hutool.core.util.StrUtil;
import cn.hutool.http.Header;
import cn.hutool.http.HttpUtil;
import cn.hutool.http.Method;
import com.core.tools.constant.ApiConstant;
import com.core.tools.constant.BaseConstant;
import com.core.tools.service.WeatherService;
import org.springframework.stereotype.Service;

/**
 * @author wb
 * @description:
 * @date 2022/11/29 14:37
 */
@Service
public class WeatherServiceImpl implements WeatherService {
    @Override
    public String search(String city) {
        String param = "?city="+city;
        return HttpUtil.createRequest(Method.GET, ApiConstant.QUERY_WEATHER_INFO + param)
                .header(Header.AUTHORIZATION, BaseConstant.JISUTQYBMF_TOKEN)
                .execute().body();
    }
}
