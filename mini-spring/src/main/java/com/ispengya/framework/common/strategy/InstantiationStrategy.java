package com.ispengya.framework.common.strategy;

import com.ispengya.framework.beans.factory.config.BeanDefinition;
import com.ispengya.framework.common.exception.BeansException;

import java.lang.reflect.Constructor;

public interface InstantiationStrategy {

    Object instantiate(BeanDefinition beanDefinition, String beanName, Constructor ctor, Object[] args) throws BeansException;

}
