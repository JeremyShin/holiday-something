package com.holidaysomething.holidaysomething.controller.user.order;

import com.holidaysomething.holidaysomething.domain.Member;
import com.holidaysomething.holidaysomething.domain.ProductOption;
import com.holidaysomething.holidaysomething.dto.AddOrderMemberDto;
import com.holidaysomething.holidaysomething.dto.ProductOptionCommand;
import com.holidaysomething.holidaysomething.dto.ProductOrderInfoCommand;
import com.holidaysomething.holidaysomething.dto.ProductOrderInfoDto;
import com.holidaysomething.holidaysomething.security.MemberUserDetails;
import com.holidaysomething.holidaysomething.service.member.MemberService;
import com.holidaysomething.holidaysomething.service.order.OrderService;
import com.holidaysomething.holidaysomething.service.product.ProductOrderService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user/order")
@Slf4j
@RequiredArgsConstructor
public class UserOrderController {
  private final OrderService orderService;
  private final MemberService memberService;
  private final ProductOrderService productOrderService;


  //어떤 회원이 주문했는지 받아오기, 어떤 상품을 주문했는지 받아오기
  @GetMapping
  public String order(Model model,
      @AuthenticationPrincipal MemberUserDetails userDetails,
      ProductOrderInfoCommand poc){

    AddOrderMemberDto addOrderMemberDto = memberService.findMemberById(userDetails.getId());
    model.addAttribute("addOrderMemberDto",addOrderMemberDto);

    // ProductOrderInfoCommand 를 ProductOrderInfo의 리스트로 바꾸어주는 메소드
    List<ProductOrderInfoDto> productOrderInfoDtos = productOrderService.fromProductOrderInfoCommandToProductOrderInfoList(poc);




    //model.addAttribute("productOrderInfoDto", productOrderInfoDto);





    return "user/order";
  }

  //주문 버튼을 누르면, orderd_product, order, shipping, payment에 데이터가 추가됨
  @PostMapping
  public void orderPost(){

  }





}
