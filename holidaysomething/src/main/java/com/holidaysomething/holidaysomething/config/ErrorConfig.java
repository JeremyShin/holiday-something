package com.holidaysomething.holidaysomething.config;

import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.server.ErrorPage;
import org.springframework.boot.web.servlet.server.ConfigurableServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;

/**
 * @author choijaeyong on 20/01/2019.
 * @project holidaysomething
 * @description
 *
 * 사이트 에러 발생시 톰캣 에러 페이지나 Whitelabel 페이지를 안 보이게 하고.
 * 커스텀 페이지를 보이게 만드는 설정파일.
 * 개발시엔 에러페이지가 보이는게 나을 것 같아서 일단 기능은 막아놓은 상태!
 * 활성화 방법 : @Configuration 주석 제거
 * MyErrorController 의 @Controller 주석 제거.
 */

//@Configuration
public class ErrorConfig {

  @Bean
  public ConfigurableServletWebServerFactory webServerFactory() {
    TomcatServletWebServerFactory factory = new
        TomcatServletWebServerFactory();
    factory.addErrorPages(new ErrorPage(HttpStatus.NOT_FOUND, "/error"));
    factory.addErrorPages(new ErrorPage(HttpStatus.INTERNAL_SERVER_ERROR, "/error"));
    factory.addErrorPages(new ErrorPage(HttpStatus.FORBIDDEN, "/error"));

    return factory;
  }

}
