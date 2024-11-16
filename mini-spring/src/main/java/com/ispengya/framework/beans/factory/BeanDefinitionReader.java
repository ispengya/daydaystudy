package com.ispengya.framework.beans.factory;

import com.ispengya.framework.exception.BeansException;
import com.ispengya.framework.beans.io.Resource;
import com.ispengya.framework.beans.io.ResourceLoader;

public interface BeanDefinitionReader {

    BeanDefinitionRegistry getRegistry();

    ResourceLoader getResourceLoader();

    void loadBeanDefinitions(Resource resource) throws BeansException;

    void loadBeanDefinitions(Resource... resources) throws BeansException;

    void loadBeanDefinitions(String location) throws BeansException;

}
