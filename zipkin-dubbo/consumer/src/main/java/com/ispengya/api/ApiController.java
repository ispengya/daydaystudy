package com.ispengya.api;

import com.ispengya.DemoService;
import org.apache.dubbo.config.annotation.DubboReference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description:
 * @author: hanzhipeng
 * @create: 2024-12-21 17:48
 **/
@RestController
public class ApiController {

    private static final Logger log = LoggerFactory.getLogger(ApiController.class);
    @DubboReference
    DemoService demoService;

    @GetMapping("/test")
    public String test() {
        log.info("hhhhh");
        demoService.sayHello("hhh");
        return "test";
    }
}
