package com.holidaysomething.holidaysomething.dto;

import com.holidaysomething.holidaysomething.domain.ProductCategory;
import com.holidaysomething.holidaysomething.domain.ProductDetail;
import com.holidaysomething.holidaysomething.domain.ProductImage;
import com.holidaysomething.holidaysomething.domain.ProductOption;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

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


    private ProductCategory productCategory;


    private ProductDetail productDetail;

    private Set<ProductImage> productImages;

    private Set<ProductOption> productOptions;
}