package com.holidaysomething.holidaysomething.controller.admin;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
@Slf4j
public class AdminMainController {

  @GetMapping
  public String index() {
    log.info("index method");
    return "admin/index";
  }
}
