package com.holidaysomething.holidaysomething.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

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
  public String main() {
    return "public/index";
  }
}
