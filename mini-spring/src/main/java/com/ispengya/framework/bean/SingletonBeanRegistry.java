package com.ispengya.framework.bean;

/**
 * 单例注册表
 */
public interface SingletonBeanRegistry {

    Object getSingleton(String beanName);

}