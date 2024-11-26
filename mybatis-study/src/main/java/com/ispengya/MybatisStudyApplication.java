package com.ispengya;

import com.ispengya.spring.bean.Person;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class MybatisStudyApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(MybatisStudyApplication.class, args);
        Person person = (Person) context.getBean(Person.class);
        person.sayHello();
    }

}
