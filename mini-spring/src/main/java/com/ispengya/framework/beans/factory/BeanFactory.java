package com.ispengya.framework.beans.factory;

import com.ispengya.framework.exception.BeansException;


public interface BeanFactory {

    //核心接口
    Object getBean(String name);
    Object getBean(String name, Object... args) throws BeansException;

}
