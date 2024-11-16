package com.ispengya.framework.beans.factory.support;

import com.ispengya.framework.beans.factory.BeanDefinitionReader;
import com.ispengya.framework.beans.factory.BeanDefinitionRegistry;
import com.ispengya.framework.beans.io.ResourceLoader;
import com.ispengya.framework.beans.io.support.DefaultResourceLoader;

public abstract class AbstractBeanDefinitionReader implements BeanDefinitionReader {

    private final BeanDefinitionRegistry registry;

    private ResourceLoader resourceLoader;

    protected AbstractBeanDefinitionReader(BeanDefinitionRegistry registry) {
        this(registry, new DefaultResourceLoader());
    }

    public AbstractBeanDefinitionReader(BeanDefinitionRegistry registry, ResourceLoader resourceLoader) {
        this.registry = registry;
        this.resourceLoader = resourceLoader;
    }

    @Override
    public BeanDefinitionRegistry getRegistry() {
        return registry;
    }

    @Override
    public ResourceLoader getResourceLoader() {
        return resourceLoader;
    }

}