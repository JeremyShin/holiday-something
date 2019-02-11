package com.holidaysomething.holidaysomething.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author choijaeyong on 19/01/2019.
 * @project holidaysomething
 * @description
 */

@Configuration
@EnableWebMvc
public class WebMvcConfig implements WebMvcConfigurer {

//  @Bean
//  public BCryptPasswordEncoder passwordEncoder() {
//    BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
//    return bCryptPasswordEncoder;
//  }

  @Override
  public void addResourceHandlers(ResourceHandlerRegistry registry) {
    // resource handler를 추가, 이 url에 접근시 handler가 trigger됨
    registry.addResourceHandler("/static/**")
        // resource의 위치를 추가한다.
        .addResourceLocations("classpath:/static/", "classpath:/templates/public/static/");
  }

//  @Override
//  public void addResourceHandlers(ResourceHandlerRegistry registry) {
//    registry
//        .addResourceHandler("/resources/**")
//        .addResourceLocations("/resourcf;
//  }
}
