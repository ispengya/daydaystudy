package com.ispengya.framework.beans.context.lifecycle.system;

import com.ispengya.framework.beans.context.ApplicationContext;
import com.ispengya.framework.beans.context.lifecycle.BeanPostProcessor;
import com.ispengya.framework.beans.context.lifecycle.ApplicationContextAware;
import com.ispengya.framework.common.exception.BeansException;

public class ApplicationContextAwareProcessor implements BeanPostProcessor {

    private final ApplicationContext applicationContext;

    public ApplicationContextAwareProcessor(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if (bean instanceof ApplicationContextAware){
            ((ApplicationContextAware) bean).setApplicationContext(applicationContext);
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }

}
