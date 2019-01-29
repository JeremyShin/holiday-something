package com.holidaysomething.holidaysomething.security;

import org.springframework.boot.autoconfigure.web.servlet.ConditionalOnMissingFilterBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @author choijaeyong on 19/01/2019.
 * @project holidaysomething
 * @description
 */

@Configuration
@EnableWebMvc
public class WebMvcConfig extends WebMvcConfigurerAdapter implements WebMvcConfigurer {

//  @Bean
//  public BCryptPasswordEncoder passwordEncoder() {
//    BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
//    return bCryptPasswordEncoder;
//  }

  @Override
  public void addResourceHandlers(ResourceHandlerRegistry registry) {
    registry.addResourceHandler("/static/**") // resource handler를 추가, 이 url에 접근시 handler가 trigger됨
        .addResourceLocations("classpath:/static/",
            "classpath:/templates/public/static/");  // resource의 위치를 추가한다.
  }

  @Override
  public void addViewControllers(ViewControllerRegistry registry) {
    registry.addViewController("/{spring:\\w+}")
        .setViewName("forward:/");
    registry.addViewController("/**/{spring:\\w+}")
        .setViewName("forward:/");
    registry.addViewController("/{spring:\\w+}/**{spring:?!(\\.js|\\.css)$}")
        .setViewName("forward:/");
  }

//  @Override
//  public void addResourceHandlers(ResourceHandlerRegistry registry) {
//    registry
//        .addResourceHandler("/resources/**")
//        .addResourceLocations("/resourcf;
//  }


}
