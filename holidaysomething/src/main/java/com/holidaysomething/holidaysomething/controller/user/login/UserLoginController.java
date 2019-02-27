package com.holidaysomething.holidaysomething.controller.user.login;

import javax.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author choijaeyong on 18/01/2019.
 * @project holidaysomething
 */
@Controller
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserLoginController {

  @GetMapping("/login")
  public String loginForm(HttpSession httpSession) {
    if (httpSession.getAttribute("LOGINUSER") != null) {
      return "redirect:/";
    }

    return "user/login/login-form";
  }
}









