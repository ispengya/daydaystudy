package com.ispengya.framework.beans.factory.core;

import com.ispengya.framework.beans.context.lifecycle.DisposableBean;
import com.ispengya.framework.beans.factory.SingletonBeanRegistry;
import com.ispengya.framework.common.exception.BeansException;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class DefaultSingletonBeanRegistry implements SingletonBeanRegistry {

    //存放单例Bean的真正地方
    private final Map<String, Object> singletonObjects = new HashMap<>();
    private final Map<String, DisposableBean> disposableBeans = new HashMap<>();
    protected static final Object NULL_OBJECT = new Object();

    @Override
    public Object getSingleton(String beanName) {
        return singletonObjects.get(beanName);
    }

    @Override
    public void destroySingletons() {
        Set<String> keySet = this.disposableBeans.keySet();
        Object[] disposableBeanNames = keySet.toArray();

        for (int i = disposableBeanNames.length - 1; i >= 0; i--) {
            Object beanName = disposableBeanNames[i];
            DisposableBean disposableBean = disposableBeans.remove(beanName);
            try {
                //执行的都是封装好的DisposableBeanAdapter
                disposableBean.destroy();
            } catch (Exception e) {
                throw new BeansException("Destroy method on bean with name '" + beanName + "' threw an exception", e);
            }
        }
    }

    protected void addSingleton(String beanName, Object singletonObject) {
        singletonObjects.put(beanName, singletonObject);
    }

    public void registerSingleton(String beanName, Object singletonObject) {
        singletonObjects.put(beanName, singletonObject);
    }

    public void registerDisposableBean(String beanName, DisposableBean bean) {
        disposableBeans.put(beanName, bean);
    }

}