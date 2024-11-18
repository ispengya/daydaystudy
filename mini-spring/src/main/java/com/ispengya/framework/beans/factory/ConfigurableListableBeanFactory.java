package com.ispengya.framework.beans.factory;

import com.ispengya.framework.beans.model.BeanDefinition;
import com.ispengya.framework.common.exception.BeansException;

public interface ConfigurableListableBeanFactory extends ListableBeanFactory, AutowireCapableBeanFactory, ConfigurableBeanFactory {

    BeanDefinition getBeanDefinition(String beanName) throws BeansException;

    void preInstantiateSingletons() throws BeansException;

}