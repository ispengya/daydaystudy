package com.ispengya.framework.common.utils;

import com.ispengya.framework.beans.factory.FactoryBean;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public class ClassUtils {

    public static ClassLoader getDefaultClassLoader() {
        ClassLoader cl = null;
        try {
            cl = Thread.currentThread().getContextClassLoader();
        }
        catch (Throwable ex) {
            // Cannot access thread context ClassLoader - falling back to system class loader...
        }
        if (cl == null) {
            // No thread context class loader -> use class loader of this class.
            cl = ClassUtils.class.getClassLoader();
        }
        return cl;
    }

    public static boolean isCglibProxyClass(Class<?> clazz) {
        return (clazz != null && isCglibProxyClassName(clazz.getName()));
    }

    /**
     * Check whether the specified class name is a CGLIB-generated class.
     * @param className the class name to check
     */
    public static boolean isCglibProxyClassName(String className) {
        return (className != null && className.contains("$$"));
    }

    /**
     * 判断某个类是否匹配FactoryBean的泛型T
     *
     * @param factoryBeanClass FactoryBean的类
     * @param targetClass      目标类
     * @return 如果目标类是FactoryBean的泛型T，则返回true；否则返回false
     */
    public static boolean isFactoryBeanTargetType(Class<? extends FactoryBean<?>> factoryBeanClass, Class<?> targetClass) {
        if (factoryBeanClass == null || targetClass == null) {
            return false;
        }

        // 获取FactoryBean的泛型类型
        Type[] genericInterfaces = factoryBeanClass.getGenericInterfaces();
        for (Type type : genericInterfaces) {
            if (type instanceof ParameterizedType) {
                ParameterizedType parameterizedType = (ParameterizedType) type;

                // 检查是否是FactoryBean接口
                if (FactoryBean.class.equals(parameterizedType.getRawType())) {
                    Type genericType = parameterizedType.getActualTypeArguments()[0];
                    if (genericType instanceof Class) {
                        // 判断目标类是否匹配泛型T
                        return targetClass.isAssignableFrom((Class<?>) genericType);
                    }
                }
            }
        }

        // 如果未找到泛型信息
        return false;
    }

}