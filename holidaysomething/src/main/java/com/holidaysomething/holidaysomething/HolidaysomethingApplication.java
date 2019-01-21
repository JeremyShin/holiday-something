package com.holidaysomething.holidaysomething;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/*
 * Member 도메인에서 LocalDateTime을 사용하기 위해서 삽입(Spring Data JPA 1.8 이상부터 사용 가능하다.
 */
@EntityScan(
        basePackageClasses = {Jsr310JpaConverters.class},  // basePackageClasses에 지정
        basePackages = {"com.holidaysomething.holidaysomething.domain"}) // basePackages도 추가로 반드시 지정해줘야 한다
@SpringBootApplication
public class HolidaysomethingApplication implements WebMvcConfigurer {

  public static void main(String[] args) {
    SpringApplication.run(HolidaysomethingApplication.class, args);
  }

  @Override
  public void addResourceHandlers(ResourceHandlerRegistry registry) {
    registry.addResourceHandler("/static/**") // resource handler를 추가, 이 url에 접근시 handler가 trigger됨
        .addResourceLocations("classpath:/static/", "classpath:/templates/public/static/");  // resource의 위치를 추가한다.
  }
}
