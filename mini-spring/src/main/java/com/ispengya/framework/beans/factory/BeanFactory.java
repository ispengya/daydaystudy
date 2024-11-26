package com.ispengya.framework.beans.factory;

import com.ispengya.framework.common.exception.BeansException;


/**
 * 顶级接口，最基础的bean工厂接口
 */
public interface BeanFactory {

    Object getBean(String name);

    Object getBean(String name, Object... args) throws BeansException;

    <T> T getBean(String name, Class<T> requiredType) throws BeansException;

    <T> T getBean(Class<T> requiredType) throws BeansException;

}
