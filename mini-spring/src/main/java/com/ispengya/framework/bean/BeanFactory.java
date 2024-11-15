package com.ispengya.framework.bean;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


public interface BeanFactory {

    //核心接口
    public Object getBean(String name);

}
