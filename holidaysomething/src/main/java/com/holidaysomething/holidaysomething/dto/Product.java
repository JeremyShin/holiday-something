package com.holidaysomething.holidaysomething.dto;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "PRODUCT")
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

    @Column(length = 255, nullable = false)
    private String code;

    @Column(length = 255, nullable = false)
    private String manufacturer;

    @Column(nullable = false)
    private int shippingPrice;

    @Column(nullable = false)
    private int quantity;

    @Column(length = 255)
    private String optionalPriceText;

    @ManyToOne
    @JoinColumn(name = "PRODUCT_ID")
    private ProductCategory productCategory;

    @OneToOne
    @JoinColumn(name = "PRODUCT_DETAIL_ID")
    private ProductDetail productDetail;

    @OneToMany(mappedBy = "PRODUCT")
    private List<ProductReview> productReviews;

    @OneToMany(mappedBy = "PRODUCT")
    private List<ProductQuestion> productQuestions;

    @OneToMany(mappedBy = "PRODUCT")
    private List<ProductImage> productImages;

    @ManyToMany
    @JoinTable(name = "PRODUCT_CONTENTS",
            joinColumns = @JoinColumn(name = "PRODUCT_ID"),
            inverseJoinColumns = @JoinColumn(name = "CONTENT_ID"))
    private List<Content> contents;

    @ManyToMany
    @JoinTable(name = "WISH_PRODUCTS",
            joinColumns = @JoinColumn(name = "PRODUCT_ID"),
            inverseJoinColumns = @JoinColumn(name = "MEMBER_ID"))
    private List<Member> members;

}