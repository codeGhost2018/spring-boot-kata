package com.tim.kata.proxy;

import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import(ProxyBeanSelector.class)
public @interface EnableInterfaceProxy {

    boolean hahafensi() default false;

}
