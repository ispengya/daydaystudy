package com.ispengya.framework.beans.factory.aware;

import com.ispengya.framework.beans.context.ApplicationContext;
import com.ispengya.framework.exception.BeansException;

public interface ApplicationContextAware extends Aware {

    void setApplicationContext(ApplicationContext applicationContext) throws BeansException;

}
