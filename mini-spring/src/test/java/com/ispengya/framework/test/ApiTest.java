package com.ispengya.framework.test;

import cn.hutool.core.io.IoUtil;
import com.ispengya.framework.aop.AdvisedSupport;
import com.ispengya.framework.aop.TargetSource;
import com.ispengya.framework.aop.support.AspectJExpressionPointcut;
import com.ispengya.framework.aop.support.Cglib2AopProxy;
import com.ispengya.framework.aop.support.JdkDynamicAopProxy;
import com.ispengya.framework.beans.context.core.ClassPathXmlApplicationContext;
import com.ispengya.framework.beans.reader.Resource;
import com.ispengya.framework.beans.reader.support.DefaultResourceLoader;
import com.ispengya.framework.test.aop.IPersonService;
import com.ispengya.framework.test.aop.PersonService;
import com.ispengya.framework.test.aop.PersonServiceInterceptor;
import com.ispengya.framework.test.bean.CustomEvent;
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
//        PersonService userService = (PersonService) beanFactory.getBean("userService", PersonService.class);
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
//        PersonService userService = applicationContext.getBean("userService", PersonService.class);
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

        // 2. 调用代理方法
        UserService userService = applicationContext.getBean("userService", UserService.class);
        System.out.println("测试结果：" + userService.queryUserInfo());
    }

    @Test
    public void test_event() {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring.xml");
        applicationContext.publishEvent(new CustomEvent(applicationContext, 1019129009086763L, "成功了！"));
        applicationContext.registerShutdownHook();
    }

    @Test
    public void test_dynamic() {
        // 目标对象
        IPersonService userService = new PersonService();

        // 组装代理信息
        AdvisedSupport advisedSupport = new AdvisedSupport();
        advisedSupport.setTargetSource(new TargetSource(userService));
        advisedSupport.setMethodInterceptor(new PersonServiceInterceptor());
        advisedSupport.setMethodMatcher(new AspectJExpressionPointcut("execution(* com.ispengya.framework.test.aop.IPersonService.*(..))"));

        // 代理对象(JdkDynamicAopProxy)
        IPersonService proxy_jdk = (IPersonService) new JdkDynamicAopProxy(advisedSupport).getProxy();
        // 测试调用
        System.out.println("测试结果：" + proxy_jdk.queryUserInfo());

        // 代理对象(Cglib2AopProxy)
        IPersonService proxy_cglib = (IPersonService) new Cglib2AopProxy(advisedSupport).getProxy();
        // 测试调用
        System.out.println("测试结果：" + proxy_cglib.register("花花"));
    }


}
