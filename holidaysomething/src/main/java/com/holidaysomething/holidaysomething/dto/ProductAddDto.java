package com.holidaysomething.holidaysomething.dto;

import com.holidaysomething.holidaysomething.domain.ProductCategory;
import com.holidaysomething.holidaysomething.domain.ProductDetail;
import com.holidaysomething.holidaysomething.domain.ProductImage;
import com.holidaysomething.holidaysomething.domain.ProductOption;
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
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class ProductAddDto {


  @NotEmpty(message = "name must be not null")
  private String name;

  @NotNull(message = "originalPrice must be not null")
  @Min(value = 0, message = "originalPrice higher than 0")
  private Integer originalPrice;

  @NotNull(message = "sellingPrice must be not null")
  @Min(value = 0, message = "sellingPrice higher than 0")
  private Integer sellingPrice;

  @NotNull(message = "manufacturingPrice must be not null")
  @Min(value = 0, message = "manufacturingPrice higher than 0")
  private Integer manufacturingPrice;

  @NotEmpty(message = "code must be not null")
  private String code;

  @NotEmpty(message = "manufacturer must be not null")
  private String manufacturer;

  @NotNull(message = "shippingPrice must be not null")
  @Min(value = 0, message = "shippingPrice higher than 0")
  private Integer shippingPrice;

  @NotNull(message = "quantity must be not null")
  @Min(value = 0, message = "quantity higher than 0")
  private Integer quantity;

  private Integer sellingQuantity;

  private Integer safeQuantity;

  private Integer mileage;

  private Boolean display;

  private String optionalPriceText;

  private LocalDateTime regDate;

  @NotEmpty(message = "manufactureDate must be not null")
  private String manufactureDate;

  @NotEmpty(message = "releaseDate must be not null")
  private String releaseDate;

  //private ProductCategory productCategory;
  @NotNull(message = "productCategory must be not null")
  private Long productCategoryId;

  //private ProductDetail productDetail;
  @NotNull(message = "productDetail must be not null")
  private String productDetail;

  private Set<ProductImage> productImages;
  private Set<ProductOption> productOptions;
}