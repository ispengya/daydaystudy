package com.ispengya.framework.beans.factory.core;

import com.ispengya.framework.beans.context.lifecycle.BeanPostProcessor;
import com.ispengya.framework.beans.factory.ConfigurableBeanFactory;
import com.ispengya.framework.beans.model.BeanDefinition;
import com.ispengya.framework.beans.factory.FactoryBean;
import com.ispengya.framework.common.exception.BeansException;
import com.ispengya.framework.common.utils.ClassUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * BeanDefinition 注册表接口
 * 1. 继承BeanFactory实现核心接口，使用模版方法核心交给子类完成
 * 2. 继承DefaultSingletonBeanRegistry便于使用获取单例bean
 */
public abstract class AbstractBeanFactory extends FactoryBeanRegistrySupport implements ConfigurableBeanFactory {

    private final List<BeanPostProcessor> beanPostProcessors = new ArrayList<BeanPostProcessor>();

    private ClassLoader beanClassLoader = ClassUtils.getDefaultClassLoader();

    protected abstract BeanDefinition getBeanDefinition(String beanName) throws BeansException;

    protected abstract Object createBean(String beanName, BeanDefinition beanDefinition, Object[] args) throws BeansException;

    @Override
    public Object getBean(String name) throws BeansException {
        return doGetBean(name, null);
    }

    @Override
    public Object getBean(String name, Object... args) throws BeansException {
        return doGetBean(name, args);
    }

    @Override
    public <T> T getBean(String name, Class<T> requiredType) throws BeansException {
        return (T) getBean(name);
    }

    //核心方法
    protected <T> T doGetBean(final String name, final Object[] args) {
        Object sharedInstance = getSingleton(name);
        if (sharedInstance != null) {
            //为什么不直接返回？假设是需要FactoryBean
            //1. getSingleton拿到的只是FactoryBean，而不是里面我们真正关心的内容
            //2. getObjectForBeanInstance则进一步判断，拿到com.ispengya.framework.beans.factory.core.FactoryBeanRegistrySupport.factoryBeanObjectCache
            //   这个里面所真正缓存的FactoryBean所代理的真实对象
            return (T) getObjectForBeanInstance(sharedInstance, name);
        }
        BeanDefinition beanDefinition = getBeanDefinition(name);
        Object bean = createBean(name, beanDefinition, args);
        return (T) getObjectForBeanInstance(bean, name);
    }

    //兼顾FactoryBean抽出的方法
    private Object getObjectForBeanInstance(Object beanInstance, String beanName) {
        // 如果不是FactoryBean，直接返回即可
        if (!(beanInstance instanceof FactoryBean)) {
            return beanInstance;
        }

        //从factoryBeanObjectCache拿到真实的才进行返回使用
        Object object = getCachedObjectForFactoryBean(beanName);
        if (object == null) {
            FactoryBean<?> factoryBean = (FactoryBean<?>) beanInstance;
            object = getObjectFromFactoryBean(factoryBean, beanName);
        }

        return object;
    }

    @Override
    public void addBeanPostProcessor(BeanPostProcessor beanPostProcessor){
        this.beanPostProcessors.remove(beanPostProcessor);
        this.beanPostProcessors.add(beanPostProcessor);
    }

    public List<BeanPostProcessor> getBeanPostProcessors() {
        return this.beanPostProcessors;
    }

    public ClassLoader getBeanClassLoader() {
        return this.beanClassLoader;
    }

}