package com.tim.kata.proxy;

import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.ClassPathBeanDefinitionScanner;
import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ResourceLoader;
import org.springframework.core.type.AnnotationMetadata;

public class ProxyBeanSelector implements ImportSelector, EnvironmentAware {

    private final static String PROXY_PACKAGE_ENV = "interface.proxy.package";
    private Environment environment;


    @Override
    public String[] selectImports(AnnotationMetadata annotationMetadata) {
        System.out.println(annotationMetadata.getClassName());
        String property = environment.getProperty(PROXY_PACKAGE_ENV);
        System.out.println(property);
        return new String[0];
    }

    @Override
    public void setEnvironment(Environment environment) {
        this.environment = environment;
    }
}
