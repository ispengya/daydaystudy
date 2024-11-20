package com.ispengya.framework.test.config;

import com.ispengya.framework.beans.context.lifecycle.BeanPostProcessor;
import com.ispengya.framework.common.exception.BeansException;

public class MyBeanPostProcessor implements BeanPostProcessor {

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
//        if ("userService".equals(beanName)) {
//            PersonService userService = (PersonService) bean;
//            userService.setLocation("北京");
//        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }

}
