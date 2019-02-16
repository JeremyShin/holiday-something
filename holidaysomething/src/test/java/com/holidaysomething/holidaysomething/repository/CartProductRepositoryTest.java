package com.holidaysomething.holidaysomething.repository;


import com.holidaysomething.holidaysomething.domain.CartProduct;
import com.holidaysomething.holidaysomething.domain.Member;
import com.holidaysomething.holidaysomething.domain.Product;
import com.holidaysomething.holidaysomething.domain.ProductOption;
import com.holidaysomething.holidaysomething.dto.UserCartProductDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@DataJpaTest
public class CartProductRepositoryTest {

    @Autowired
    CartProductRepository cartProductRepository;

    @Autowired
    MemberRepository memberRepository;

    @Autowired
    ProductRepository productRepository;

    @Autowired
    ProductOptionRepository productOptionRepository;

    @Test
    public void tpatest() {
//        List<UserCartProductDto> cartProductById = cartProductRepository.findCartProductById(1L);
//        List<CartProduct> cartProducts = cartProductRepository.findCartProductByUserId(1L);

        CartProduct cartProduct1 = cartProductRepository.findCartProductByIds(1L, 1L, 1L);
        if (cartProduct1 == null) {
            CartProduct cartProduct2 = new CartProduct();

            Member member = memberRepository.getOne(2L);
            cartProduct2.setMember(member);

            Product product = productRepository.getOne(3L);
            cartProduct2.setProduct(product);

            ProductOption productOption = productOptionRepository.getOne(4L);
            cartProduct2.setProductOption(productOption);

            cartProduct2.setQuantity(2);

            cartProductRepository.save(cartProduct2);
        } else {
            System.out.println(cartProduct1.getQuantity());
            cartProduct1.setQuantity(50);
            System.out.println(cartProduct1.getQuantity());
        }
//
//        for (CartProduct cartProduct : cartProducts) {
//            if (cartProduct.getMember().getId().equals(1L) && cartProduct.getProduct().getId().equals(1L) && cartProduct.getProductOption().getId().equals(1L)) {
//                CartProduct cartProductByIds = cartProductRepository.getCartProductByIds(1L, 1L, 1L);
//
//                System.out.println("================");
//                System.out.println(cartProductByIds.getId());
//                System.out.println(cartProductByIds.getQuantity());
//                System.out.println(cartProductByIds.getProductOption().getId());
//                System.out.println(cartProductByIds.getProduct().getId());
//                System.out.println(cartProductByIds.getMember().getId());
//
//            } else {
//
//                CartProduct cartProduct2 = new CartProduct();
//
//                Member member = memberRepository.getOne(1L);
//                cartProduct2.setMember(member);
//
//                Product product = productRepository.getOne(1L);
//                cartProduct2.setProduct(product);
//
//                ProductOption productOption = productOptionRepository.getOne(1L);
//                cartProduct2.setProductOption(productOption);
//
//                cartProduct2.setQuantity(2);
//
//                CartProduct save = cartProductRepository.save(cartProduct2);
//
//                System.out.println(save.getId());
//                System.out.println(save.getMember().getId());
//                System.out.println(save.getProduct().getId());
//                System.out.println(save.getProductOption().getId());
//                System.out.println(save.getQuantity());
//            }

//            CartProduct cartProductByIds = cartProductRepository.getCartProductByIds(1L, 1L, 1L);
    }


}