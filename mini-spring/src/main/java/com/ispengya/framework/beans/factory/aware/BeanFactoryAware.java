package com.ispengya.framework.beans.factory.aware;

import com.ispengya.framework.beans.factory.BeanFactory;
import com.ispengya.framework.exception.BeansException;

public interface BeanFactoryAware extends Aware {

   void setBeanFactory(BeanFactory beanFactory) throws BeansException;

}
