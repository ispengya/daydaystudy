package com.ispengya.framework.test.config;

import com.ispengya.framework.beans.context.BeanFactoryPostProcessor;
import com.ispengya.framework.beans.factory.ConfigurableListableBeanFactory;
import com.ispengya.framework.beans.factory.config.BeanDefinition;
import com.ispengya.framework.beans.factory.config.PropertyValue;
import com.ispengya.framework.beans.factory.config.PropertyValues;
import com.ispengya.framework.exception.BeansException;

public class MyBeanFactoryPostProcessor implements BeanFactoryPostProcessor {

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {

        BeanDefinition beanDefinition = beanFactory.getBeanDefinition("userService");
        PropertyValues propertyValues = beanDefinition.getPropertyValues();

        propertyValues.addPropertyValue(new PropertyValue("company", "改为：字节跳动"));
    }

}
