package com.tim.kata.core;

import org.springframework.context.ApplicationContextAware;
import org.springframework.core.ResolvableType;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.TypeVariable;

public interface Decorator<DOWN> {

    DOWN convertTo(Object input);

    default boolean isMatch(Object parentOutput) {
        Class<?> supportClass = (Class<?>)((ParameterizedType) ResolvableType.forInstance(this).resolve().getGenericSuperclass()).getActualTypeArguments()[1];
        return supportClass.isInstance(parentOutput);
    }


}
