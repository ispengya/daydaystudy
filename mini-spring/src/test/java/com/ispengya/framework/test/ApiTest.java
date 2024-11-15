package com.ispengya.framework.test;

import com.ispengya.framework.bean.base.BeanDefinition;
import com.ispengya.framework.bean.support.DefaultListableBeanFactory;
import com.ispengya.framework.test.bean.UserService;
import org.junit.Test;

public class ApiTest {
    @Test
    public void test_BeanFactory(){
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        BeanDefinition beanDefinition = new BeanDefinition(UserService.class);
        beanFactory.registerBeanDefinition("userService", beanDefinition);
        UserService userService = (UserService) beanFactory.getBean("userService");
        userService.queryUserInfo();
    }

}
