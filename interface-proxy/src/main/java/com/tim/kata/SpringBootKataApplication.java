package com.tim.kata;

import com.tim.kata.proxy.EnableInterfaceProxy;
import com.tim.kata.proxy.ProxyBeanSelector;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
//@Import(ProxyBeanSelector.class)
@EnableInterfaceProxy
public class SpringBootKataApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootKataApplication.class, args);
	}

}
