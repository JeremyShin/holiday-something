package com.holidaysomething.holidaysomething.dto;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    @OneToMany(mappedBy = "product")
    private Set<ProductCounpon> productCounpons;

    @OneToMany(mappedBy = "product")
    private Set<ProductQuestion> productQuestions;
}
