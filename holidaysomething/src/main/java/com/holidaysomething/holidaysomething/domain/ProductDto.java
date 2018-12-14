package com.holidaysomething.holidaysomething.domain;

import lombok.Data;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;

@Data
public class ProductDto {
    private Long id;
    private String name;
    private int originalPrice;
    private int sellingPrice;

    private int manufacturingPrice;

    private String code;
    private String manufacturer;

    private int shippingPrice;

    private int quantity;

    private int sellingQuantity;

    private int safeQuantity;

    private int mileage;

    private Boolean display;
    private String optionalPriceText;
    private LocalDateTime regDate;
    private LocalDateTime manufactureDate;
    private LocalDateTime releaseDate;


    private Long productCategoryId;
    private String productDescription;

    //private Set<ProductImage> productImages;
    //private Set<ProductOption> productOptions;
}