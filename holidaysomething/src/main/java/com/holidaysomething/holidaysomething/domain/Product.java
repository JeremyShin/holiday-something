package com.holidaysomething.holidaysomething.domain;

import java.time.LocalDateTime;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "PRODUCT")
@Getter
@Setter
public class Product {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;


  // String은 form 태그 안에 input 에서 아무것도 입력하지 않으면 null 로 처리되는게 안리ㅏ
  // "" 로 처리된다.
  @Column(length = 100, nullable = false)
  private String name;

  @Column(nullable = false)
  private Integer originalPrice;

  @Column(nullable = false)
  private Integer sellingPrice;

  @Column(nullable = false)
  private Integer manufacturingPrice;

  @Column(nullable = false)
  private String code;

  @Column(nullable = false)
  private String manufacturer;

  @Column(nullable = false, columnDefinition = "integer default 0")
  private Integer shippingPrice;

  @Column(nullable = false, columnDefinition = "integer default 0")
  private Integer quantity;

  @Column(columnDefinition = "integer default 0")
  private Integer sellingQuantity;

  @Column(columnDefinition = "integer default 0")
  private Integer safeQuantity;

  @Column(columnDefinition = "integer default 0")
  private Integer mileage;

  private Boolean display;
  private String optionalPriceText;
  private LocalDateTime regDate;


  private LocalDateTime manufactureDate;


  private LocalDateTime releaseDate;

  @ManyToOne
  private ProductCategory productCategory;

  @OneToOne
  @JoinColumn(name = "product_detail_id")
  private ProductDetail productDetail;

  @OneToMany(mappedBy = "product")
  private Set<ProductImage> productImages;

  @OneToMany(mappedBy = "product")
  private Set<ProductOption> productOptions;
}