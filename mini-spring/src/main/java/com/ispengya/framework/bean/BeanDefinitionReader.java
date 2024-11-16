package com.ispengya.framework.bean;

import com.ispengya.framework.exception.BeansException;
import com.ispengya.framework.io.Resource;
import com.ispengya.framework.io.ResourceLoader;

public interface BeanDefinitionReader {

    BeanDefinitionRegistry getRegistry();

    ResourceLoader getResourceLoader();

    void loadBeanDefinitions(Resource resource) throws BeansException;

    void loadBeanDefinitions(Resource... resources) throws BeansException;

    void loadBeanDefinitions(String location) throws BeansException;

}
