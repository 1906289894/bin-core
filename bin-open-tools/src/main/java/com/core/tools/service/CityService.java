package com.core.tools.service;

import com.core.tools.entity.City;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author wb
 * @since 2022-11-29
 */
public interface CityService extends IService<City> {

    //通过Api接口获取城市数据
    Boolean generateCity();
}
