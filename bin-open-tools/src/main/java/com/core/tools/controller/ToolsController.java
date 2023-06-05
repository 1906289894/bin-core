package com.core.tools.controller;

import cn.hutool.core.date.DatePattern;
import cn.hutool.core.date.LocalDateTimeUtil;
import cn.hutool.http.HttpUtil;
import com.core.tools.constant.ApiConstant;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletRequest;
import javax.xml.transform.Source;
import java.time.LocalDate;

/**
 * @author wb
 * @description:
 * @date 2022/11/29 16:02
 */
@RestController
@RequestMapping("/tools")
public class ToolsController {
    @GetMapping("/historyToday")
    public String historyToday(){
        LocalDate now = LocalDate.now();
        String format = LocalDateTimeUtil.format(now, "MM/dd");
        System.err.println(format);
        String key = "78b3ceda51f1a6ddbdae9edabcab1b79";
        return HttpUtil.get(ApiConstant.TODAYONHISTORY + "?key=78b3ceda51f1a6ddbdae9edabcab1b79&date=" + format);
    }
}
