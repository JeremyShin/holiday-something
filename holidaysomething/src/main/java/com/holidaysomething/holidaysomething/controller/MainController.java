package com.holidaysomething.holidaysomething.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
public class MainController {

  @RequestMapping("/")
  public String index() {
    return "index";
  }

  /**
   * 회원 마이페이지
   */
  @RequestMapping("/mypage")
  public String main(Authentication authentication) {
    if (authentication == null) {
      log.info("\"/mypage\": No authenticated user.");
      return "redirect:/user/login";
    }

    return "public/index";
  }
}
