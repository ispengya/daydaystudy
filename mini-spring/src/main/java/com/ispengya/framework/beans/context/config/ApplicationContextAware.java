package com.ispengya.framework.beans.context.config;

import com.ispengya.framework.beans.context.ApplicationContext;
import com.ispengya.framework.common.exception.BeansException;

public interface ApplicationContextAware extends Aware {

    void setApplicationContext(ApplicationContext applicationContext) throws BeansException;

}
