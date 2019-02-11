package com.holidaysomething.holidaysomething.service.product;

import com.holidaysomething.holidaysomething.dto.UserCartProductDto;
import com.holidaysomething.holidaysomething.repository.CartProductRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Gyumin Kim
 * @since 2019-02-11
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class CartProductServiceImpl implements CartProductService {

  private final CartProductRepository cartProductRepository;

  @Override
  @Transactional(readOnly = true)
  public List<UserCartProductDto> getUserCartProduct(Long userId) {
    return cartProductRepository.findCartProductById(userId);
  }

  @Override
  @Transactional
  public void removeCartProductById(Long cartProductId) {
    cartProductRepository.deleteById(cartProductId);
  }
}
