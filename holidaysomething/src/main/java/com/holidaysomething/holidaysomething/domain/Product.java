package com.holidaysomething.holidaysomething.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "PRODUCTS")
@Getter
@Setter
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 100, nullable = false)
    private String name;

    @Column(nullable = false)
    private int originalPrice;

    @Column(nullable = false)
    private int sellingPrice;

    @Column(nullable = false)
    private String code;

    @Column(nullable = false)
    private String manufacturer;

    @Column(nullable = false)
    private int shippingPrice;

    @Column(nullable = false)
    private int quantity;

    private String optionalPriceText;

    @ManyToOne
    @JoinColumn(name = "product_category_id")
    private ProductCategory productCategory;

    @OneToOne
    @JoinColumn(name = "product_detail_id")
    private ProductDetail productDetail;

    @OneToMany(mappedBy = "product")
    private Set<ProductImage> productImages;
}