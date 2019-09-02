package com.jiurn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @Package: com.jiurn
 * @ClassName: StarAplication
 * @Author: ${zhouzhiqiang}
 * @Date: 27/7/2019 14:03
 */
@SpringBootApplication
@EnableScheduling
@EnableTransactionManagement
public class StarAplication {
    public static void main(String[] args) {
        SpringApplication.run(StarAplication.class, args);

    }
}
