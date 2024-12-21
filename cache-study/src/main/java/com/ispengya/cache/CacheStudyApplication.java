package com.ispengya.cache;

import com.yomahub.tlog.core.enhance.bytes.AspectLogEnhance;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CacheStudyApplication {

    static {
        // 进行日志增强，自动判断日志框架
        AspectLogEnhance.enhance();
    }

    public static void main(String[] args) {

        SpringApplication.run(CacheStudyApplication.class, args);
    }

}
