package com.holidaysomething.holidaysomething.service.product;

import com.holidaysomething.holidaysomething.domain.CartProduct;
import com.holidaysomething.holidaysomething.domain.Product;
import com.holidaysomething.holidaysomething.dto.ProductOrderInfoDto;
import com.holidaysomething.holidaysomething.dto.UserCartProductDto;
import com.holidaysomething.holidaysomething.repository.CartProductRepository;
import java.util.List;

import com.holidaysomething.holidaysomething.repository.MemberRepository;
import com.holidaysomething.holidaysomething.repository.ProductOptionRepository;
import com.holidaysomething.holidaysomething.repository.ProductRepository;
import com.holidaysomething.holidaysomething.service.member.MemberService;
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
  private final ProductRepository productRepository;
  private final ProductOptionRepository productOptionRepository;
  private final MemberRepository memberRepository;

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

  @Override
  public void save(ProductOrderInfoDto productOrderInfoDto, Long userId) {
    Product product = productRepository.getOne(productOrderInfoDto.getProductId());

    CartProduct cartProduct = new CartProduct();
    cartProduct.setMember(memberRepository.getOne(userId));
    cartProduct.setProduct(product);
    cartProduct.setProductOption(productOptionRepository.getOne(productOrderInfoDto.getOptionId()));
    cartProduct.setQuantity(productOrderInfoDto.getQuantity());

    cartProductRepository.save(cartProduct);
  }
}
