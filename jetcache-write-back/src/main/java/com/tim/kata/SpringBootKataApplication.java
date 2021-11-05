package com.tim.kata;

import com.alicp.jetcache.anno.config.EnableCreateCacheAnnotation;
import com.alicp.jetcache.anno.config.EnableMethodCache;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableCreateCacheAnnotation
@EnableMethodCache(basePackages = "com.tim.kata")
public class SpringBootKataApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootKataApplication.class, args);
    }

}
