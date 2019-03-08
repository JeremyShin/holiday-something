package com.holidaysomething.holidaysomething.config;

import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.server.ErrorPage;
import org.springframework.boot.web.servlet.server.ConfigurableServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;

/**
 * @author choijaeyong on 20/01/2019.
 * @project holidaysomething
 * 사이트 에러 발생시 톰캣 에러 페이지나 Whitelabel 페이지를 안 보이게 하고. 커스텀 페이지를 보이게 만드는 설정파일. 개발시엔 에러페이지가
 * 보이는게 나을 것 같아서 일단 기능은 막아놓은 상태! 활성화 방법 : @Configuration 주석 제거 MyErrorController 의 @Controller 주석
 * 제거.
 */

//@Configuration
public class ErrorConfig {

  /**
   * Customizing Embedded Servlet Containers
   * ConfigurableServletWebServerFactory를 직접 customizing하는 방법
   * (TomcatServletWebServerFactory 객체를 등록)
   * 참고: https://docs.spring.io/spring-boot/docs/current/reference/html/boot-features-developing-web-applications.html#boot-features-customizing-configurableservletwebserverfactory-directly
   */
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
