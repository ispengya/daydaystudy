package com.ispengya;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Hello world!
 *
 */
@SpringBootApplication
@EnableDubbo
public class ProviderApp
{
    public static void main( String[] args )
    {
        SpringApplication.run(ProviderApp.class, args);
    }
}
