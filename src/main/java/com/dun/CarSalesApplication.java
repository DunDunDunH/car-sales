package com.dun;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.dun.mapper")
public class CarSalesApplication {

    public static void main(String[] args) {
        SpringApplication.run(CarSalesApplication.class, args);
    }
}
