package com.core.bin.user.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
/**
 * @author wang
 * @date 2022-02-18 17:50
 */
@RestController
@RequestMapping("/core/user")
@AllArgsConstructor
public class UserController {

    @GetMapping("/test")
    public String login(){
        //userService.getOne();
        return "SUCCESS";
    }
}
