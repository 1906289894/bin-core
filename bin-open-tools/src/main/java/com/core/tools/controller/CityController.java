package com.core.tools.controller;

import com.core.bin.common.api.CommonResult;
import com.core.tools.service.CityService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author wb
 * @since 2022-11-29
 */
@RestController
@RequestMapping("/tools/city")
@RequiredArgsConstructor
public class CityController {

    private final CityService cityService;

    @PostMapping("/generate")
    public CommonResult<Boolean> generate(){
        return CommonResult.success(cityService.generateCity());
    }
}
