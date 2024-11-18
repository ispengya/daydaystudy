package com.ispengya.framework.beans.context.lifecycle;

import com.ispengya.framework.beans.context.ApplicationContext;
import com.ispengya.framework.common.exception.BeansException;

public interface ApplicationContextAware extends Aware {

    void setApplicationContext(ApplicationContext applicationContext) throws BeansException;

}
