package com.ispengya.framework.beans.factory;

import com.ispengya.framework.beans.factory.base.BeanDefinition;
import com.ispengya.framework.exception.BeansException;

public interface ConfigurableListableBeanFactory extends ListableBeanFactory, AutowireCapableBeanFactory, ConfigurableBeanFactory {

    BeanDefinition getBeanDefinition(String beanName) throws BeansException;

}