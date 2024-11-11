package com.ispengya.config;

import com.ispengya.plugin.ExamplePlugin;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MybatisConfig {

    @Bean
    public ExamplePlugin examplePlugin(){
        return new ExamplePlugin();
    }
}
