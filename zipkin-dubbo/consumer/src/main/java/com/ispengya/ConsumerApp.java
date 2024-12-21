package com.ispengya;

import org.apache.dubbo.config.annotation.DubboReference;
import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @description:
 * @author: hanzhipeng
 * @create: 2024-12-21 17:32
 **/
@SpringBootApplication
@EnableDubbo
public class ConsumerApp {

    private static final Logger log = LoggerFactory.getLogger(ConsumerApp.class);
    @DubboReference
    DemoService demoService;

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(ConsumerApp.class, args);
        DemoService demo = context.getBean(DemoService.class);
        log.info(demo.sayHello("hanzhipeng"));
    }

}
