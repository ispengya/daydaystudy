package com.ispengya.framework.beans.context.config;

import com.ispengya.framework.beans.factory.config.PropertyValues;
import com.ispengya.framework.common.exception.BeansException;

public interface InstantiationAwareBeanPostProcessor extends BeanPostProcessor {

    /**
     * 在 Bean 对象执行实例化方法之前，执行此方法
     */
    @Deprecated
    Object postProcessBeforeInstantiation(Class<?> beanClass, String beanName) throws BeansException;

    /**
     * 在 Bean 对象执行实例化方法之后，执行此方法
     * 例如：
     */
    boolean postProcessAfterInstantiation(Object bean, String beanName) throws BeansException;

    /**
     * 在 Bean 对象实例化完成后，设置属性操作之前执行此方法
     */
    PropertyValues postProcessPropertyValues(PropertyValues pvs, Object bean, String beanName) throws BeansException;


    default Object getEarlyBeanReference(Object bean, String beanName) {
        return bean;
    }

}