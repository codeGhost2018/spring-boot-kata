package com.tim.kata;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.tim.kata.dao")
public class SpringBootKataApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootKataApplication.class, args);
    }

}
