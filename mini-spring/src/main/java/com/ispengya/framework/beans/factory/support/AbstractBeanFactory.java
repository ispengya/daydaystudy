package com.ispengya.framework.beans.factory.support;

import com.ispengya.framework.beans.factory.BeanFactory;
import com.ispengya.framework.beans.factory.base.BeanDefinition;
import com.ispengya.framework.exception.BeansException;

/**
 * BeanDefinition 注册表接口
 * 1. 继承BeanFactory实现核心接口，使用模版方法核心交给子类完成
 * 2. 继承DefaultSingletonBeanRegistry便于使用获取单例bean
 */
public abstract class AbstractBeanFactory extends DefaultSingletonBeanRegistry implements BeanFactory {

    @Override
    public Object getBean(String name) throws BeansException {
        return doGetBean(name,null);
    }

    @Override
    public Object getBean(String name, Object... args) throws BeansException {
        return doGetBean(name,args);
    }

    protected <T> T doGetBean(final String name, final Object[] args) {
        //为什么继承DefaultSingletonBeanRegistry，因为在这里面直接new并不能很好的解偶，而继承既能很好避免这个问题
        //那我想使用这个getSingleton功能，但是我不想new就可以这样进行使用
        Object bean = getSingleton(name);
        if (bean != null) {
            return (T) bean;
        }
        //核心继续交给子类完成
        BeanDefinition beanDefinition = getBeanDefinition(name);
        return (T) createBean(name, beanDefinition, args);
    }

    protected abstract BeanDefinition getBeanDefinition(String beanName) throws BeansException;

    protected abstract Object createBean(String beanName, BeanDefinition beanDefinition, Object[] args) throws BeansException;

}