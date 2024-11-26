package com.ispengya.framework.beans.context.annotation;

import cn.hutool.core.util.ClassUtil;
import com.ispengya.framework.beans.factory.FactoryBean;
import com.ispengya.framework.beans.factory.config.BeanDefinition;

import java.util.LinkedHashSet;
import java.util.Set;

public class ClassPathScanningCandidateComponentProvider {

    public Set<BeanDefinition> findCandidateComponents(String basePackage) {
        Set<BeanDefinition> candidates = new LinkedHashSet<>();
        Set<Class<?>> classes = ClassUtil.scanPackageByAnnotation(basePackage, Component.class);
        for (Class<?> clazz : classes) {
            boolean factoryBean = FactoryBean.class.isAssignableFrom(clazz);
            candidates.add(new BeanDefinition(clazz, factoryBean));
        }
        return candidates;
    }

}
