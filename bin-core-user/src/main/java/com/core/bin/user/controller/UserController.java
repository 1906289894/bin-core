package com.core.bin.user.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.core.bin.common.api.CommonResult;
import com.core.bin.common.exception.ApiException;
import com.core.bin.user.service.UserService;
import com.core.bin.user.entity.User;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.Random;

/**
 * @author wang
 * @date 2022-02-18 17:50
 */
@RestController
@RequestMapping("/core/user")
@AllArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/test")
    public String login(){
        //userService.getOne();
        return "SUCCESS";
    }

    @PostMapping("/login")
    public CommonResult<Boolean> login(@RequestBody User user){
        User username = userService.getOne(new QueryWrapper<User>().eq("username", user.getUsername()));
        if (Objects.isNull(username)) {
            throw new ApiException("用户不存在");
        }
        if (!username.getPassword().equals(user.getPassword())) {
            throw new ApiException("密码不正确");
        }
        return CommonResult.success(true);
    }

    @GetMapping
    public User get(){
        return userService.getById(1);
    }

    @PostMapping
    public void save(@RequestBody User user){
        int i = new Random().nextInt(1000000);
        user.setPassword(String.valueOf(i));
        user.setCreateTime(LocalDateTime.now());
        user.setUpdateTime(LocalDateTime.now());
        userService.save(user);
    }
}
