package com.holidaysomething.holidaysomething.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Product {
    private Long id;
    private String name;
    private int originalPrice;
    private int sellingPrice;
    private String code;
    private String manufacturer;
    private int shippingPrice;
    private int quantity;
    private String optionalPriceText;
    private Long productCategoryId;
    private Long productDetailId;
}
