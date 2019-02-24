package com.holidaysomething.holidaysomething.controller.user.order;

import com.holidaysomething.holidaysomething.service.product.CartProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping(path = "/api/user",
    produces = "application/json")
@CrossOrigin(origins = "*")
public class UserCartRestController {

  private CartProductService cartProductService;

  public UserCartRestController(CartProductService cartProductService) {
    this.cartProductService = cartProductService;
  }

  /**
   * cart 내의 특정 상품을 cart에서 삭제
   */
  @DeleteMapping("/cart/{cartProductId}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void deleteCartProduct(@PathVariable("cartProductId") Long id) {
    try {
      cartProductService.removeCartProductById(id);
    } catch (EmptyResultDataAccessException e) {
      e.printStackTrace();
    }
  }
}
