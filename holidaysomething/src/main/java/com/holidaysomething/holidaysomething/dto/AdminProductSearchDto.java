package com.holidaysomething.holidaysomething.dto;

import org.springframework.format.annotation.DateTimeFormat;

/**
 * @author Gyumin Kim
 * @since 2019-03-01
 */
public class AdminProductSearchDto {

  private String productSearchClassification;
  private String productSearchClassificationInput;
  private Long productLargeCategoryId;
  private Long productMiddleCategoryId;
  private Long productSmallCategoryId;
  private String productDate;

  @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
  private String productRegDateStart;

  @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
  private String productRegDateEnd;

  public AdminProductSearchDto(String productSearchClassification,
      String productSearchClassificationInput, Long productLargeCategoryId,
      Long productMiddleCategoryId, Long productSmallCategoryId, String productDate,
      String productRegDateStart, String productRegDateEnd) {
    this.productSearchClassification = productSearchClassification;
    this.productSearchClassificationInput = productSearchClassificationInput;
    this.productLargeCategoryId = productLargeCategoryId;
    this.productMiddleCategoryId = productMiddleCategoryId;
    this.productSmallCategoryId = productSmallCategoryId;
    this.productDate = productDate;
    this.productRegDateStart = productRegDateStart;
    this.productRegDateEnd = productRegDateEnd;
  }

  public String getProductSearchClassification() {
    return productSearchClassification;
  }

  public String getProductSearchClassificationInput() {
    return productSearchClassificationInput;
  }

  public Long getProductLargeCategoryId() {
    return productLargeCategoryId;
  }

  public Long getProductMiddleCategoryId() {
    return productMiddleCategoryId;
  }

  public Long getProductSmallCategoryId() {
    return productSmallCategoryId;
  }

  public String getProductDate() {
    return productDate;
  }

  public String getProductRegDateStart() {
    return productRegDateStart;
  }

  public String getProductRegDateEnd() {
    return productRegDateEnd;
  }
}
