package com.holidaysomething.holidaysomething;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;

/*
 * Member 도메인에서 LocalDateTime을 사용하기 위해서 삽입(Spring Data JPA 1.8 이상부터 사용 가능하다.
 */
@EntityScan(
        basePackageClasses = {Jsr310JpaConverters.class},  // basePackageClasses에 지정
        basePackages = {"com.holidaysomething.holidaysomething.domain"}) // basePackages도 추가로 반드시 지정해줘야 한다
@SpringBootApplication
public class HolidaysomethingApplication {

    // AWS Properties 설정을 읽을 수 있도록 함.
    public static final String APPLICATION_LOCATION = "spring.config.location=" +
            "classpath:application.properties," +
            "classpath:aws.properties";

    public static void main(String[] args) {
        new SpringApplicationBuilder(HolidaysomethingApplication.class)
                .properties(APPLICATION_LOCATION)
                .run(args);
    }
}
