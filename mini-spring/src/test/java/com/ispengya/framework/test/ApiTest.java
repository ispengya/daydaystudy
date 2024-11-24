package com.ispengya.framework.test;

import com.ispengya.framework.beans.context.core.ClassPathXmlApplicationContext;
import com.ispengya.framework.test.bean.IUserService;
import org.junit.Test;

public class ApiTest {

//    @Test
//    public void test_aop() {
//        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring.xml");
//        IUserService userService = applicationContext.getBean("userService", IUserService.class);
//        System.out.println("测试结果：" + userService.queryUserInfo());
//    }

    @Test
    public void test_property() {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring-property.xml");
        IUserService userService = applicationContext.getBean("userService", IUserService.class);
        System.out.println("测试结果：" + userService);
    }

    @Test
    public void test_scan() {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring-property.xml");
        IUserService userService = applicationContext.getBean("userService", IUserService.class);
        System.out.println("测试结果：" + userService.queryUserInfo());
    }



}
