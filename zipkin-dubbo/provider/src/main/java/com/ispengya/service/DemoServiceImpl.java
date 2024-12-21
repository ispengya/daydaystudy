package com.ispengya.service;

import com.ispengya.DemoService;
import org.apache.dubbo.config.annotation.DubboService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @description:
 * @author: hanzhipeng
 * @create: 2024-12-21 17:30
 **/
@DubboService
public class DemoServiceImpl implements DemoService {

    private static final Logger log = LoggerFactory.getLogger(DemoServiceImpl.class);

    @Override
    public String sayHello(String name) {
        log.info("sayHello : {}", name);
        return "你好 " + name;
    }
}
