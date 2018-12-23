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


/*

181222

주문회원 조회 : 주문기간, 주문번호, 이름/아이디 검색.
 */