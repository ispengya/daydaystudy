package com.ispengya.framework.bean.support;

import com.ispengya.framework.bean.BeanFactory;
import com.ispengya.framework.bean.base.BeanDefinition;
import com.ispengya.framework.exception.BeansException;

/**
 * BeanDefinition 注册表接口
 * 1. 继承BeanFactory实现核心接口，使用模版方法核心交给子类完成
 * 2. 继承DefaultSingletonBeanRegistry便于使用获取单例bean
 */
public abstract class AbstractBeanFactory extends DefaultSingletonBeanRegistry implements BeanFactory {

    @Override
    public Object getBean(String name) throws BeansException {
        //为什么继承DefaultSingletonBeanRegistry，因为在这里面直接new并不能很好的解偶，而继承既能很好避免这个问题
        Object bean = getSingleton(name);
        if (bean != null) {
            return bean;
        }
        //核心继续交给子类完成
        BeanDefinition beanDefinition = getBeanDefinition(name);
        return createBean(name, beanDefinition);
    }

    protected abstract BeanDefinition getBeanDefinition(String beanName) throws BeansException;

    protected abstract Object createBean(String beanName, BeanDefinition beanDefinition) throws BeansException;

}