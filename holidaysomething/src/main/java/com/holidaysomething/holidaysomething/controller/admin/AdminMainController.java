package com.holidaysomething.holidaysomething.controller.admin;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminMainController {

  private static final Log log = LogFactory.getLog(AdminMainController.class);

  @GetMapping
  public String index() {
    log.info("index method");
    return "admin/index";
  }
}
