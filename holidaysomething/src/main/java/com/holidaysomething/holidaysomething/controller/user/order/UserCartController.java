package com.holidaysomething.holidaysomething.controller.user.order;

import com.holidaysomething.holidaysomething.dto.UserCartProductDto;
import com.holidaysomething.holidaysomething.security.MemberUserDetails;
import com.holidaysomething.holidaysomething.service.product.CartProductService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
   * @param authentication 현재 로그인 되어 있는 유저 정보
   * @return cart 페이지(cart.html)
   * 현재 로그인된 유저가 갖고있는 cart_product 목록을 가져온다.
   */
  @GetMapping("/cart")
  public String cartAuth(Authentication authentication, ModelMap modelMap) {
    if (authentication == null) {
      log.info("\"/user/cart\": No authenticated user.");
      return "redirect:/user/login";
    }

    Long userId = ((MemberUserDetails) authentication.getPrincipal()).getMember().getId();
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

    return "user/cart";
  }
}
