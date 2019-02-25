package com.holidaysomething.holidaysomething.controller.user;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
@Slf4j
public class UserMainController {

  @GetMapping
  public String index(){
    return "/user/index";
  }

  @RequestMapping("/mypage")
  public String main(Authentication authentication) {
    if (authentication == null) {
      log.info("\"/mypage\": No authenticated user.");
      return "redirect:/user/login";
    }

    return "public/index";
  }
}
