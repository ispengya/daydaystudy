package com.ispengya.framework.beans.factory;

import com.ispengya.framework.beans.factory.base.BeanDefinition;
import com.ispengya.framework.exception.BeansException;

import java.lang.reflect.Constructor;

public interface InstantiationStrategy {

    Object instantiate(BeanDefinition beanDefinition, String beanName, Constructor ctor, Object[] args) throws BeansException;

}
