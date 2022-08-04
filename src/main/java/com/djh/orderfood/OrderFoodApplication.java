package com.djh.orderfood;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "com.djh.orderfood.dao")
public class OrderFoodApplication {

    public static void main(String[] args) {
        SpringApplication.run(OrderFoodApplication.class, args);
    }

}
