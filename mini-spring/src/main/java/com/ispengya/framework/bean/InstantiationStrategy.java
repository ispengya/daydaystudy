package com.ispengya.framework.bean;

import com.ispengya.framework.bean.base.BeanDefinition;
import com.ispengya.framework.exception.BeansException;

import java.lang.reflect.Constructor;

public interface InstantiationStrategy {

    Object instantiate(BeanDefinition beanDefinition, String beanName, Constructor ctor, Object[] args) throws BeansException;

}
