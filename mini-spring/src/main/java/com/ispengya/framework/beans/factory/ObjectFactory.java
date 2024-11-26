package com.ispengya.framework.beans.factory;

import com.ispengya.framework.common.exception.BeansException;

public interface ObjectFactory<T> {

    T getObject() throws BeansException;

}
