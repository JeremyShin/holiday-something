package com.holidaysomething.holidaysomething;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.thymeleaf.dialect.springdata.SpringDataDialect;
import org.thymeleaf.extras.java8time.dialect.Java8TimeDialect;

@SpringBootApplication
public class HolidaysomethingApplication {

    // thymeleaf 날짜
//    @Bean
//    public Java8TimeDialect java8TimeDialect() {
//        return new Java8TimeDialect();
//    }

    // thymeleaf 페이징
//    @Bean
//    public SpringDataDialect springDataDialect() {
//        return new SpringDataDialect();
//    }

    public static void main(String[] args) {

        SpringApplication.run(HolidaysomethingApplication.class, args);
    }
}
