package com.ispengya.framework.test.config;

import com.ispengya.framework.beans.context.lifecycle.BeanFactoryPostProcessor;
import com.ispengya.framework.beans.factory.ConfigurableListableBeanFactory;
import com.ispengya.framework.beans.model.BeanDefinition;
import com.ispengya.framework.beans.model.PropertyValue;
import com.ispengya.framework.beans.model.PropertyValues;
import com.ispengya.framework.common.exception.BeansException;

public class MyBeanFactoryPostProcessor implements BeanFactoryPostProcessor {

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {

        BeanDefinition beanDefinition = beanFactory.getBeanDefinition("userService");
        PropertyValues propertyValues = beanDefinition.getPropertyValues();

        propertyValues.addPropertyValue(new PropertyValue("company", "字节跳动"));
    }

}
