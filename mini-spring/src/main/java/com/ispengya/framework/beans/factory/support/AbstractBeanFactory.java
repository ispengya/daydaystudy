package com.ispengya.framework.beans.factory.support;

import com.ispengya.framework.beans.context.config.BeanPostProcessor;
import com.ispengya.framework.beans.factory.ConfigurableBeanFactory;
import com.ispengya.framework.beans.factory.FactoryBean;
import com.ispengya.framework.beans.factory.config.BeanDefinition;
import com.ispengya.framework.common.exception.BeansException;
import com.ispengya.framework.common.utils.ClassUtils;
import com.ispengya.framework.common.utils.StringValueResolver;

import java.util.ArrayList;
import java.util.List;

/**
 * 模版方法，getBean方法大致框架构成
 */
public abstract class AbstractBeanFactory extends FactoryBeanRegistrySupport implements ConfigurableBeanFactory {

    /**
     * 存储BeanPostProcessor，bean生命周期核心流程
     */
    private final List<BeanPostProcessor> beanPostProcessors = new ArrayList<BeanPostProcessor>();

    /**
     * ${}解析器
     */
    private final List<StringValueResolver> embeddedValueResolvers = new ArrayList<>();

    private ClassLoader beanClassLoader = ClassUtils.getDefaultClassLoader();



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


    protected <T> T doGetBean(final String name, final Object[] args) {
        Object sharedInstance = getSingleton(name);
        if (sharedInstance != null) {
            //兼顾FactoryBean
            return (T) getObjectForBeanInstance(sharedInstance, name);
        }
        BeanDefinition beanDefinition = getBeanDefinition(name);
        Object bean = createBean(name, beanDefinition, args);
        return (T) getObjectForBeanInstance(bean, name);
    }


    /**
     * 为什么不直接返回？假设是需要FactoryBean
     * 1. getSingleton拿到的只是FactoryBean，而不是里面我们真正关心的内容
     * 2. getObjectForBeanInstance则进一步判断，拿到FactoryBeanRegistrySupport.factoryBeanObjectCache这个里面所真正缓存的FactoryBean所代理的真实对象
     */
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

    public List<BeanPostProcessor> getBeanPostProcessors() {
        return this.beanPostProcessors;
    }

    public ClassLoader getBeanClassLoader() {
        return this.beanClassLoader;
    }

    protected abstract BeanDefinition getBeanDefinition(String beanName) throws BeansException;

    protected abstract Object createBean(String beanName, BeanDefinition beanDefinition, Object[] args) throws BeansException;

    @Override
    public void addBeanPostProcessor(BeanPostProcessor beanPostProcessor){
        this.beanPostProcessors.remove(beanPostProcessor);
        this.beanPostProcessors.add(beanPostProcessor);
    }

    @Override
    public void addEmbeddedValueResolver(StringValueResolver valueResolver) {
        this.embeddedValueResolvers.add(valueResolver);
    }

    @Override
    public String resolveEmbeddedValue(String value) {
        String result = value;
        for (StringValueResolver resolver : this.embeddedValueResolvers) {
            result = resolver.resolveStringValue(result);
        }
        return result;
    }

}