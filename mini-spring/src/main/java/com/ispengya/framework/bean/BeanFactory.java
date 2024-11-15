package com.ispengya.framework.bean;

import com.ispengya.framework.exception.BeansException;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


public interface BeanFactory {

    //核心接口
    Object getBean(String name);
    Object getBean(String name, Object... args) throws BeansException;

}
