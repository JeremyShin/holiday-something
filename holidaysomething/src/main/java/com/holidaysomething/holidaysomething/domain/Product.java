package com.holidaysomething.holidaysomething.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

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

  @Column(nullable = false)
  private int manufacturingPrice;

  @Column(nullable = false)
  private String code;

  @Column(nullable = false)
  private String manufacturer;

  @Column(nullable = false)
  private int shippingPrice;

  @Column(nullable = false)
  private int quantity;

  @Column(columnDefinition = "integer default 0")
  private int sellingQuantity;

  @Column(columnDefinition = "integer default 0")
  private int safeQuantity;

  @Column(columnDefinition = "integer default 0")
  private int mileage;

  private Boolean display;
  private String optionalPriceText;
  private LocalDateTime regDate;
  private LocalDateTime manufactureDate;
  private LocalDateTime releaseDate;

  @ManyToOne
  @JoinColumn(name = "product_category_id")
  private ProductCategory productCategory;

  @OneToOne
  @JoinColumn(name = "product_detail_id")
  private ProductDetail productDetail;

  @OneToMany(mappedBy = "product")
  private Set<ProductImage> productImages;

  @OneToMany(mappedBy = "product")
  private Set<ProductOption> productOptions;
}