package com.holidaysomething.holidaysomething.controller.user.order;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user/order")
@Slf4j
@RequiredArgsConstructor
public class UserOrderController {
  @GetMapping
  public String order(){ return "user/order"; }
}
