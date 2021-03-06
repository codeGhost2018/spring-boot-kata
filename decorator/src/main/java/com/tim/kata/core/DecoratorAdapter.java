package com.tim.kata.core;


import com.tim.kata.ApplicationContextUtils;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.core.ResolvableType;

import java.lang.reflect.ParameterizedType;

/**
 * 装饰器适配器
 */
public abstract class DecoratorAdapter<DOWN, SUPPORT> implements Decorator<DOWN> {

    protected Decorator decorator;


    public DecoratorAdapter(Decorator decorator) {
        this.decorator = decorator;
        ApplicationContextUtils.autowire(this);
    }

    @Override
    public DOWN convertTo(Object input) {
        if(decorator != null) {
            input = this.decorator.convertTo(input);
        }
        if(!isMatch(input)) {
            throw new IllegalArgumentException();
        }
        DOWN output = this.doConvert((SUPPORT) input);
        this.appendExtras((SUPPORT)input, output);
        return output;
    }

    @Override
    public boolean isMatch(Object parentOutput) {
        Class<?> supportClass = (Class<?>)((ParameterizedType) ResolvableType.forInstance(this).resolve().getGenericSuperclass()).getActualTypeArguments()[1];
        return supportClass.isInstance(parentOutput);
    }

    protected abstract DOWN doConvert(SUPPORT input);

    protected abstract void appendExtras(SUPPORT input, DOWN output);
}
