package com.core.tools.constant;

/**
 * @author wb
 * @description:
 * @date 2022/11/29 11:45
 */
public interface ApiConstant {

    //提取城市api
    String EXTRACT_CITY_API = "https://jisutqybmf.market.alicloudapi.com/weather/city";
    //查询天气
    String QUERY_WEATHER_INFO = "https://jisutqybmf.market.alicloudapi.com/weather/query";

    //聚合数据 历史上的今天
    String TODAYONHISTORY = "http://v.juhe.cn/todayOnhistory/queryEvent.php";
}
