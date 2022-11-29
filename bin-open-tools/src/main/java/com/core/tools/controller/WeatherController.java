package com.core.tools.controller;

import com.core.tools.service.WeatherService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wb
 * @description:
 * @date 2022/11/29 14:36
 */
@RestController
@RequestMapping("/tools/weather")
@RequiredArgsConstructor
public class WeatherController {

    private final WeatherService weatherService;
    /**
     * 查询天气
     *
     * @return
     */
    @GetMapping("/search")
    public String search(String city){
        return weatherService.search(city);
    }

}
