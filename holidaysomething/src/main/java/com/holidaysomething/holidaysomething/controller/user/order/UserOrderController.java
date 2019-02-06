package com.holidaysomething.holidaysomething.controller.user.order;

import com.holidaysomething.holidaysomething.domain.Member;
import com.holidaysomething.holidaysomething.domain.Product;
import com.holidaysomething.holidaysomething.domain.ProductOption;
import com.holidaysomething.holidaysomething.dto.AddOrderMemberDto;
import com.holidaysomething.holidaysomething.dto.ProductOptionCommand;
import com.holidaysomething.holidaysomething.dto.ProductOptionDto;
import com.holidaysomething.holidaysomething.dto.ProductOrderDetailDto;
import com.holidaysomething.holidaysomething.dto.ProductOrderInfoCommand;
import com.holidaysomething.holidaysomething.dto.ProductOrderInfoDto;
import com.holidaysomething.holidaysomething.security.MemberUserDetails;
import com.holidaysomething.holidaysomething.service.member.MemberService;
import com.holidaysomething.holidaysomething.service.order.OrderService;
import com.holidaysomething.holidaysomething.service.product.ProductOptionService;
import com.holidaysomething.holidaysomething.service.product.ProductOrderService;
import com.holidaysomething.holidaysomething.service.product.ProductService;
import java.util.ArrayList;
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
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/user/product/order")
@Slf4j
@RequiredArgsConstructor
public class UserOrderController {
  private final OrderService orderService;
  private final MemberService memberService;
  private final ProductOrderService productOrderService;
  private final ProductOptionService productOptionService;
  private final ProductService productService;

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
      ProductOrderInfoCommand poc) {

    log.info("주문페이지입니다.");

    AddOrderMemberDto addOrderMemberDto = memberService.findMemberById(userDetails.getId());
    model.addAttribute("addOrderMemberDto", addOrderMemberDto);


    // ProductOrderInfoCommand 를 ProductOrderInfo의 리스트로 바꾸어주는 메소드
    // 주문할 상품들의 목록
    List<ProductOrderInfoDto> productOrderInfoDtos = productOrderService
        .fromProductOrderInfoCommandToProductOrderInfoList(poc);

    List<ProductOrderDetailDto> productOrderDetailDtos = new ArrayList<>();
    ProductOrderDetailDto productOrderDetailDto = new ProductOrderDetailDto();
    Product product;
    ProductOption productOption;

    //ProductOrderInfoDto는 productId, optionId, quantity밖에 없다. 이들을 조회하여 productOrderDetailDto에 정보를 넣어준다.
    //여러개의 productOrderDetailDto를 productOrderDetailDtos에 담아서 보낸다.
    //하나의 상품에 대해, 당연히 하나의 productOrderDetail Dto를 갖겠지,,,

   //List로 했을 때 돌아가는 코드
    for (ProductOrderInfoDto productOrderInfoDto : productOrderInfoDtos) {
      product = productService.getProduct(productOrderInfoDto.getProductId());
      log.info("productId" + product.getId());
      productOrderDetailDto = productService.getProductForOrder(productOrderDetailDto, product);

      log.info("OptionId" + productOrderInfoDto.getOptionId());
      productOption = productOptionService.getProductOption(productOrderInfoDto.getOptionId());
      productOrderDetailDto = productOptionService.getProductOptionForOrder(productOrderDetailDto, productOption, productOrderInfoDto.getQuantity());

      productOrderDetailDtos.add(productOrderDetailDto);

      log.info("주문페이지의 컨트롤러. 조회한 productOrderDetailDto의 정보를 읽어보자");
      log.info("주문 상품의 이름은" + productOrderDetailDto.getProductName());
      log.info("주문 상품의 옵션이름의 사이즈는"  + productOrderDetailDto.getOptionName());
      log.info("주문 상품의 개수는"  + productOrderDetailDto.getQuantity());
      log.info("주문 상품의 이미지는" + productOrderDetailDto.getImg());
    }


    log.info("뷰로 보낼 상품의 개수는" + productOrderDetailDtos.size());

    for (ProductOrderDetailDto p : productOrderDetailDtos){
      log.info("뷰로 보낼 옵션의 이름은 " + p.getOptionName());
      log.info("뷰로 보낼 옵션의 개수은 " + p.getQuantity());
    }


//    model.addAttribute("productOrderInfoDtos", productOrderInfoDtos);
    model.addAttribute("productOrderDetailDtos", productOrderDetailDtos);

//    for (ProductOrderInfoDto productOrderInfoDto : productOrderInfoDtos) {
//      product = productService.getProduct(productOrderInfoDto.getProductId());
//      log.info("productId" + product.getId());
//
//      log.info("옵션의 개수" + productOrderInfoDto.getOptionInfo().size());
//
//      for (Long key : productOrderInfoDto.getOptionInfo().keySet()){
//        log.info("키득");
//        log.info("옵션의 개수" + productOrderInfoDto.getOptionInfo().size());
//        log.info("옵션의 개수" + productOrderInfoDto.getOptionInfo().keySet().size());
//        log.info("현재 조회할 옵션의 id" + key);
//
//        productOption = productOptionService.getProductOption(key);
//        productOrderDetailDto = productOptionService
//            .getProductOptionForOrder(productOrderDetailDto, productOption);
//      }
//      productOrderDetailDto = productService.getProductForOrder(productOrderDetailDto, product);
//    }



//    //List로 했을 때 돌아가는 코드
//    for (ProductOrderInfoDto productOrderInfoDto : productOrderInfoDtos) {
//      product = productService.getProduct(productOrderInfoDto.getProductId());
//      log.info("productId" + product.getId());
//
//      for (int j = 0; j < productOrderInfoDto.getOptionIds().size(); j++) {
//        log.info("옵션의 개수" + productOrderInfoDto.getOptionIds().size());
//        log.info("현재 조회할 옵션의 id" + productOrderInfoDto.getOptionIds().get(j));
//        productOption = productOptionService.getProductOption(productOrderInfoDto.getOptionIds().get(j));
//        productOrderDetailDto = productOptionService
//            .getProductOptionForOrder(productOrderDetailDto, productOption);
//      }
//      productOrderDetailDto = productService.getProductForOrder(productOrderDetailDto, product);
//    }


//    //한 상품에 대한
//    for (ProductOrderInfoDto productOrderInfoDto : productOrderInfoDtos) {
//      product = productService.getProduct(productOrderInfoDto.getProductId());
//      log.info("productId" + product.getId());
//
//      for (int j = 0; j < productOrderInfoDto.getOptionIds().size(); j++) {
//        log.info("옵션의 개수" + productOrderInfoDto.getOptionIds().size());
//        log.info("현재 조회할 옵션의 id" + productOrderInfoDto.getOptionIds().get(j));
//        productOrderDetailDto = productOptionService
//            .getProductOptionForOrder(productOrderInfoDto.getOptionIds().get(j));
//      }
//      productOrderDetailDto = productService.getProductForOrder(productOrderDetailDto, product);
//    }

    return "user/order";
  }
}
