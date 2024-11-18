package com.ispengya.framework.beans.context.lifecycle;

public interface BeanClassLoaderAware extends Aware{

    void setBeanClassLoader(ClassLoader classLoader);

}
