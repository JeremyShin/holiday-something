package com.holidaysomething.holidaysomething.controller.user.order;

import com.holidaysomething.holidaysomething.domain.Member;
import com.holidaysomething.holidaysomething.dto.AddOrderMemberDto;
import com.holidaysomething.holidaysomething.security.MemberUserDetails;
import com.holidaysomething.holidaysomething.service.member.MemberService;
import com.holidaysomething.holidaysomething.service.order.OrderService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 */

@Controller
@RequestMapping("/user/order")
@Slf4j
@RequiredArgsConstructor
public class UserOrderController {
  private final OrderService orderService;
  private final MemberService memberService;


  //어떤 회원이 주문했는지 받아오기
  @GetMapping
  public String order(@AuthenticationPrincipal MemberUserDetails userDetails,
      Model model){
    //Spring Security UserDetails에서 getUsername은 현재 로그인한 유저의 login_id를 의미
    log.info("현재 로그인한 멤버의 로그인 아이디는");
    log.info(userDetails.getUsername());

    AddOrderMemberDto addOrderMemberDto = memberService.findMemberById(userDetails.getId());
    model.addAttribute("addOrderMemberDto",addOrderMemberDto);

    log.info("현재 로그인한 멤버의 이메일은");
    log.info(addOrderMemberDto.getEmail());

    return "user/order";
  }

  //주문 버튼을 누르면, orderd_product, order, shipping, payment에 데이터가 추가됨
  @PostMapping
  public void orderPost(){

  }

}
