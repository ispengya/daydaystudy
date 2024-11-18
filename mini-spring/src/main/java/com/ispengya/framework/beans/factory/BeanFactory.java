package com.ispengya.framework.beans.factory;

import com.ispengya.framework.common.exception.BeansException;


public interface BeanFactory {

    //核心接口
    Object getBean(String name);
    Object getBean(String name, Object... args) throws BeansException;
    <T> T getBean(String name, Class<T> requiredType) throws BeansException;

}
