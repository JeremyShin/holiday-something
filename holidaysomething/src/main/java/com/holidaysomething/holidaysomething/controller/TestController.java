package com.holidaysomething.holidaysomething.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class TestController {

    @PostMapping("/user/product/order")
    public String orderForm() {
        return "/user/product/order-test";
    }
}
