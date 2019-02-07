package com.holidaysomething.holidaysomething.controller;

import com.holidaysomething.holidaysomething.dto.ProductOrderInfoDto;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.constraints.NotNull;
import java.util.List;

@Controller
public class TestController {

    @PostMapping("/user/product/order")
    public String orderForm(@ModelAttribute ProductOrderInfoDto productOrderInfoDto) {

        Long productId = productOrderInfoDto.getProductId();

        Long[] optionIds = productOrderInfoDto.getOptionId();

        Integer[] orderQuantitys = productOrderInfoDto.getOrderQuantity();

        System.out.println(productId);
        System.out.println(productId);
        System.out.println(productId);
        System.out.println(productId);
        System.out.println(productId);
        System.out.println(productId);
        System.out.println(productId);
        System.out.println(productId);
        System.out.println(productId);
        System.out.println(productId);

        for(Long optionId : optionIds){
            System.out.println("==========================");
            System.out.println(optionId);
            System.out.println(optionId);
            System.out.println(optionId);
            System.out.println(optionId);
            System.out.println(optionId);
            System.out.println(optionId);
            System.out.println(optionId);
            System.out.println(optionId);
        }

        for(Integer orderQuantity : orderQuantitys) {
            System.out.println("==========================");
            System.out.println(orderQuantity);
            System.out.println(orderQuantity);
            System.out.println(orderQuantity);
            System.out.println(orderQuantity);
            System.out.println(orderQuantity);
            System.out.println(orderQuantity);
            System.out.println(orderQuantity);
            System.out.println(orderQuantity);
            System.out.println(orderQuantity);
            System.out.println(orderQuantity);
            System.out.println(orderQuantity);
            System.out.println(orderQuantity);
        }

        return "/user/product/order-test";
    }
}
