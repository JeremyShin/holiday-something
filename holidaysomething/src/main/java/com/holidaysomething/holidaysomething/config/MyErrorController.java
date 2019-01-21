package com.holidaysomething.holidaysomething.config;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

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

//@Controller
@Slf4j
public class MyErrorController implements ErrorController {

  // PATH 와 config 파일의 path 랑 일치해야한다.
  @RequestMapping("/error")
  public String handleError(HttpServletRequest request) {
    log.info("===== errors 메시지 안.");
    Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);

    if (status != null) {
      Integer statusCode = Integer.valueOf(status.toString());
      log.info("===== status if 안... statusCode : : " + statusCode);

      if (statusCode == HttpStatus.NOT_FOUND.value()) {
        log.info("===== status if 안... statusCode : : " + statusCode + ",  return 404");
        return "errors/404";
      } else if (statusCode == HttpStatus.INTERNAL_SERVER_ERROR.value()) {
        log.info("===== status if 안... statusCode : : " + statusCode + ",  return 500");
        return "errors/500";
      } else if (statusCode == HttpStatus.FORBIDDEN.value()) {
        log.info("===== status if 안... statusCode : : " + statusCode + ",  return 403");
        return "errors/403";
      }
    }
    return "error";
  }

  @Override
  public String getErrorPath() {
    log.info("========= getErrorPath 안.");
    return "/error";
  }
}
