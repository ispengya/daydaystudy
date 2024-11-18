package com.ispengya.framework.test;

import cn.hutool.core.io.IoUtil;
import com.ispengya.framework.beans.context.core.ClassPathXmlApplicationContext;
import com.ispengya.framework.beans.reader.Resource;
import com.ispengya.framework.beans.reader.support.DefaultResourceLoader;
import com.ispengya.framework.test.bean.UserService;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

public class ApiTest {

    private DefaultResourceLoader resourceLoader;

    @Before
    public void init() {
        resourceLoader = new DefaultResourceLoader();
    }

    @Test
    public void test_classpath() throws IOException {
        Resource resource = resourceLoader.getResource("classpath:important.properties");
        InputStream inputStream = resource.getInputStream();
        String content = IoUtil.readUtf8(inputStream);
        System.out.println(content);
    }

    @Test
    public void test_file() throws IOException {
        Resource resource = resourceLoader.getResource("src/test/resources/important.properties");
        InputStream inputStream = resource.getInputStream();
        String content = IoUtil.readUtf8(inputStream);
        System.out.println(content);
    }

    @Test
    public void test_url() throws IOException {
        Resource resource = resourceLoader.getResource("https://github.com/fuzhengwei/small-spring/blob/main/small-spring-step-05/src/test/resources/important.properties");
        InputStream inputStream = resource.getInputStream();
        String content = IoUtil.readUtf8(inputStream);
        System.out.println(content);
    }

//    @Test
//    public void test_xml() {
//        // 1.初始化 BeanFactory
//        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
//
//        // 2. 读取配置文件&注册Bean
//        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(beanFactory);
//        reader.loadBeanDefinitions("classpath:spring.xml");
//
//        // 3. 获取Bean对象调用方法
//        UserService userService = (UserService) beanFactory.getBean("userService", UserService.class);
//        String result = userService.queryUserInfo();
//        System.out.println("测试结果：" + result);
//    }

    //    @Test
//    public void test_context() {
//        // 1.初始化 BeanFactory
//        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring.xml");
//        applicationContext.registerShutdownHook();
//
//        // 2. 获取Bean对象调用方法
//        UserService userService = applicationContext.getBean("userService", UserService.class);
//        String result = userService.queryUserInfo();
//        System.out.println("测试结果：" + result);
//        System.out.println("ApplicationContextAware："+userService.getApplicationContext());
//        System.out.println("BeanFactoryAware："+userService.getBeanFactory());
//    }
    @Test
    public void test_prototype() {
        // 1.初始化 BeanFactory
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring.xml");
        applicationContext.registerShutdownHook();

        // 2. 获取Bean对象调用方法
        UserService userService01 = applicationContext.getBean("userService", UserService.class);
        UserService userService02 = applicationContext.getBean("userService", UserService .class);

        // 3. 配置 scope="prototype/singleton"
        System.out.println(userService01);
        System.out.println(userService02);

        // 4. 打印十六进制哈希
        System.out.println(userService01 + " 十六进制哈希：" + Integer.toHexString(userService01.hashCode()));
//            System.out.println(ClassLayout.parseInstance(userService01).toPrintable());

    }


}
