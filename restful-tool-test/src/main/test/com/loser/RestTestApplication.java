package com.loser;

import com.loser.config.EnableAnnoProxy;
import com.loser.config.EnableRestFulClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableAnnoProxy(basePackages = {"com.loser"})
@EnableRestFulClient
public class RestTestApplication {

    /**
     * 唯一启动类
     *
     * @param args 程序参数
     */
    public static void main(String[] args) {
        SpringApplication.run(RestTestApplication.class, args);
    }
}