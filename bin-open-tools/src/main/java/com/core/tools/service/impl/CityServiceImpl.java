package com.core.tools.service.impl;

import cn.hutool.http.Header;
import cn.hutool.http.HttpUtil;
import static com.core.tools.constant.ApiConstant.*;
import static com.core.tools.constant.BaseConstant.*;

import cn.hutool.http.Method;
import cn.hutool.json.JSONArray;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.core.tools.entity.City;
import com.core.tools.mapper.CityMapper;
import com.core.tools.service.CityService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author wb
 * @since 2022-11-29
 */
@Service
public class CityServiceImpl extends ServiceImpl<CityMapper, City> implements CityService {

    @Override
    public Boolean generateCity() {
        boolean flag = false;
        try {
            String body = HttpUtil.createRequest(Method.GET, EXTRACT_CITY_API)
                    .header(Header.AUTHORIZATION, JISUTQYBMF_TOKEN)
                    .execute().body();
            JSONObject entries = JSONUtil.parseObj(body);
            //查询成功
            if (entries.getInt("status") == 0){
                JSONArray jsonArray = entries.getJSONArray("result");
                List<City> cities = new ArrayList<>();
                jsonArray.forEach(e ->{
                    JSONObject jsonObject = (JSONObject)e;
                    City city = new City();
                    city.setCityCode(jsonObject.getStr("citycode"));
                    city.setCityId(jsonObject.getInt("cityid"));
                    city.setCity(jsonObject.getStr("city"));
                    city.setParentId(jsonObject.getInt("parentid"));
                    cities.add(city);
                });
                long stat = System.currentTimeMillis();
                flag = saveBatch(cities,cities.size());
                System.err.println("插入耗时："+(System.currentTimeMillis()-stat)+"ms");
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        return flag;
    }

}
