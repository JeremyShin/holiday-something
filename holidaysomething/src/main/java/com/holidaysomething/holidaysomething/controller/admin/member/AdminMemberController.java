package com.holidaysomething.holidaysomething.controller.admin.member;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin/member")
public class AdminMemberController {

  @GetMapping("/order/search")
  public String memberOrderSearch() {
    return "admin/member/member_order";
  }


}
