package com.ispengya.framework.beans.context.config;

import com.ispengya.framework.beans.factory.BeanFactory;
import com.ispengya.framework.common.exception.BeansException;

public interface BeanFactoryAware extends Aware {

   void setBeanFactory(BeanFactory beanFactory) throws BeansException;

}
