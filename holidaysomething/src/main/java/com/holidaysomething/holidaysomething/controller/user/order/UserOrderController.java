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
import javax.annotation.Nullable;
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
@RequestMapping("/user/product/order")
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

  /**
   * @Author : Misun Joo
   * 이전페이지(상품상세, 장바구니)로부터 ProductOrderInfoDto, 현재 주문하는 멤버의 정보를 받아와서 Order 페이지에 뿌려줌
   * PostMapping으로 하는 이유는, GetMapping으로 받아오면 URL에 너무 많은 정보가 표시되며, 길이에 제한도 있기 때문임
   */

  @PostMapping
  public String orderPost(Model model,
      @AuthenticationPrincipal MemberUserDetails userDetails,
      ProductOrderInfoCommand poc){

    AddOrderMemberDto addOrderMemberDto = memberService.findMemberById(userDetails.getId());
    model.addAttribute("addOrderMemberDto",addOrderMemberDto);

    // ProductOrderInfoCommand 를 ProductOrderInfo의 리스트로 바꾸어주는 메소드
    List<ProductOrderInfoDto> productOrderInfoDtos = productOrderService.fromProductOrderInfoCommandToProductOrderInfoList(poc);

    for(ProductOrderInfoDto productOrderInfoDto : productOrderInfoDtos){
      log.info(productOrderInfoDto.getProductId().toString());
      log.info(Integer.toString(productOrderInfoDto.getOptionIds().size()));
      log.info(Integer.toString(productOrderInfoDto.getOrderQuantities().size()));
    }

    //model.addAttribute("productOrderInfoDto", productOrderInfoDto);

    return "user/order";

  }

//  @PostMapping
//  public String orderPost(Model model,
//      ProductOrderInfoCommand poc){
//
//    // ProductOrderInfoCommand 를 ProductOrderInfo의 리스트로 바꾸어주는 메소드
//    List<ProductOrderInfoDto> productOrderInfoDto = productOrderService.fromProductOrderInfoCommandToProductOrderInfoList(poc);
//
//    log.info(Integer.toString(productOrderInfoDto.size()));
//
//    log.info("주문페이지로 넘어왔나?");
//    log.info(productOrderInfoDto.get(0).getProductId().toString());
//    log.info(productOrderInfoDto.get(0).getOptionIds().toString());
//    log.info(productOrderInfoDto.get(0).getOrderQuantities().toString());
//
//    log.info(Integer.toString(productOrderInfoDto.get(0).getOptionIds().size()));
//    log.info(Integer.toString(productOrderInfoDto.get(0).getOrderQuantities().size()));
//
//
//    //model.addAttribute("productOrderInfoDto", productOrderInfoDto);
//
//    return "user/order";
//
//  }


//  @PostMapping
//  public String orderPost(Model model,
//      ProductOrderInfoDto productOrderInfoDto){
//
//    // ProductOrderInfoCommand 를 ProductOrderInfo의 리스트로 바꾸어주는 메소드
//
//    log.info("주문페이지로 넘어왔나?");
//      log.info(productOrderInfoDto.getProductId().toString());
//      log.info(productOrderInfoDto.getOptionIds().toString());
//      log.info(productOrderInfoDto.getOrderQuantities().toString());
//
//      log.info(Integer.toString(productOrderInfoDto.getOptionIds().size()));
//      log.info(Integer.toString(productOrderInfoDto.getOrderQuantities().size()));
//
//    //model.addAttribute("productOrderInfoDto", productOrderInfoDto);
//
//    return "user/order";
//
//  }



}
