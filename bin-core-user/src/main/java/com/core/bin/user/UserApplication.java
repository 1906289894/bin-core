package com.core.bin.user;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author wang
 * @date 2022-02-18 17:45
 */
@MapperScan("com.core.bin.user.mapper")
@SpringBootApplication(scanBasePackages = "com.core.bin")
public class UserApplication {
    public static void main(String[] args) {
        SpringApplication.run(UserApplication.class);
    }

}
