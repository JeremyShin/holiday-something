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
 */

@Controller
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
