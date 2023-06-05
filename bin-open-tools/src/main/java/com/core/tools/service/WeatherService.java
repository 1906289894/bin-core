package com.core.tools.service;

/**
 * @author wb
 * @description:
 * @date 2022/11/29 14:37
 */
public interface WeatherService {
    /**
     * 查询天气
     * @param city 城市
     * @return 天气信息
     */
    String search(String city);

}
