package com.holidaysomething.holidaysomething.controller.user.order;

import com.holidaysomething.holidaysomething.dto.UserCartProductDto;
import com.holidaysomething.holidaysomething.service.member.MemberService;
import com.holidaysomething.holidaysomething.service.product.CartProductService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author Gyumin Kim
 * @since 2019-02-11
 */
@Controller
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserCartController {

  private final CartProductService cartProductService;

  /**
   * 현재 로그인된 유저가 갖고있는 cart_product 목록을 가져온다.
   *
   * @param userId 현재 로그인 되어 있는 유저의 id
   * @return cart 페이지(cart.html)
   *
   * 상품-옵션 별 수량 --> 현재 table에 정의되어 있지 않음, 나중에 구현
   *
   * TODO: 현재는 url에 id를 입력해야 함. 향후 Authentication을 사용해 현재 로그인 되어 있는 유저의 cart를 가져오는 것으로 수정
   */
  @GetMapping("/cart")
  public String cart(@RequestParam("id") Long userId, ModelMap modelMap) {
    List<UserCartProductDto> cartProducts = cartProductService.getUserCartProduct(userId);
    modelMap.addAttribute("cartProducts", cartProducts);

    int totalPrice = 0;
    int totalShippingPrice = 0;
    for (UserCartProductDto cartProduct : cartProducts) {
      totalPrice += (cartProduct.getSellingPrice() * cartProduct.getQuantity());
      totalShippingPrice += cartProduct.getShippingPrice();
    }
    int totalPaymentPrice = totalPrice + totalShippingPrice;

    modelMap.addAttribute("totalPrice", totalPrice);
    modelMap.addAttribute("productCount", cartProducts.size());
    modelMap.addAttribute("totalShippingPrice", totalShippingPrice);
    modelMap.addAttribute("totalPaymentPrice", totalPaymentPrice);

//    log.info("============= UserCartProductDto 반복문 =============");
//    for (UserCartProductDto userCartProductDto : cartProducts) {
//      log.info("cartProductId: " + userCartProductDto.getCartProductId());
//      log.info("productId: " + userCartProductDto.getProductId());
//      log.info("productName: " + userCartProductDto.getProductName());
//      log.info("quantity: " + userCartProductDto.getQuantity());
//      log.info("originalPrice: " + userCartProductDto.getOriginalPrice());
//      log.info("sellingPrice: " + userCartProductDto.getSellingPrice());
//      log.info("shippingPrice: " + userCartProductDto.getShippingPrice());
//      log.info("imagePath: " + userCartProductDto.getImagePath());
//      log.info("==================================================");
//    }

    return "user/cart";
  }
}
