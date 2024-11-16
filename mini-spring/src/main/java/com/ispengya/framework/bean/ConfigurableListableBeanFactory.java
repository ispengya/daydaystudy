package com.ispengya.framework.bean;

import com.ispengya.framework.bean.base.BeanDefinition;
import com.ispengya.framework.exception.BeansException;

public interface ConfigurableListableBeanFactory extends ListableBeanFactory, AutowireCapableBeanFactory, ConfigurableBeanFactory {

    BeanDefinition getBeanDefinition(String beanName) throws BeansException;

}