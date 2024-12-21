package com.ispengya.log;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description:
 * @author: hanzhipeng
 * @create: 2024-12-21 10:38
 **/
@RestController
public class ApiController {

    private static final Logger log = LoggerFactory.getLogger(ApiController.class);

    @GetMapping("/test")
    public String test() {
        log.info("tset");
        return "test";
    }
}
