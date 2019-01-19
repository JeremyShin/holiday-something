package com.holidaysomething.holidaysomething.security;

import org.springframework.boot.autoconfigure.web.servlet.ConditionalOnMissingFilterBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
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


}
