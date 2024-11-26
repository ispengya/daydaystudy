package com.ispengya.framework.beans.io;

import com.ispengya.framework.beans.factory.BeanDefinitionRegistry;
import com.ispengya.framework.common.exception.BeansException;

public interface BeanDefinitionReader {

    BeanDefinitionRegistry getRegistry();

    ResourceLoader getResourceLoader();

    void loadBeanDefinitions(Resource resource) throws BeansException;

    void loadBeanDefinitions(Resource... resources) throws BeansException;

    void loadBeanDefinitions(String location) throws BeansException;

    void loadBeanDefinitions(String... locations) throws BeansException;

}
