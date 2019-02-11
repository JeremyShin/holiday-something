package com.holidaysomething.holidaysomething.dto;

/**
 * @author Gyumin Kim
 * @since 2019-02-07
 */
public class UserCartProductDto {

  private Long cartProductId;
  private Long productId;
  private String productName;
  private Integer quantity;
  private Integer originalPrice;
  private Integer sellingPrice;
  private Integer shippingPrice;
  private String imagePath;
  private String productOptionName;
  private Integer productOptionPrice;
  private String productOptionDescription;

  public UserCartProductDto(Long cartProductId, Long productId, String productName,
      Integer quantity, Integer originalPrice, Integer sellingPrice, Integer shippingPrice,
      String imagePath, String productOptionName, Integer productOptionPrice,
      String productOptionDescription) {
    this.cartProductId = cartProductId;
    this.productId = productId;
    this.productName = productName;
    this.quantity = quantity;
    this.originalPrice = originalPrice;
    this.sellingPrice = sellingPrice;
    this.shippingPrice = shippingPrice;
    this.imagePath = imagePath;
    this.productOptionName = productOptionName;
    this.productOptionPrice = productOptionPrice;
    this.productOptionDescription = productOptionDescription;
  }

  public Long getCartProductId() {
    return cartProductId;
  }

  public void setCartProductId(Long cartProductId) {
    this.cartProductId = cartProductId;
  }

  public Long getProductId() {
    return productId;
  }

  public void setProductId(Long productId) {
    this.productId = productId;
  }

  public String getProductName() {
    return productName;
  }

  public void setProductName(String productName) {
    this.productName = productName;
  }

  public Integer getQuantity() {
    return quantity;
  }

  public void setQuantity(Integer quantity) {
    this.quantity = quantity;
  }

  public Integer getOriginalPrice() {
    return originalPrice;
  }

  public void setOriginalPrice(Integer originalPrice) {
    this.originalPrice = originalPrice;
  }

  public Integer getSellingPrice() {
    return sellingPrice;
  }

  public void setSellingPrice(Integer sellingPrice) {
    this.sellingPrice = sellingPrice;
  }

  public Integer getShippingPrice() {
    return shippingPrice;
  }

  public void setShippingPrice(Integer shippingPrice) {
    this.shippingPrice = shippingPrice;
  }

  public String getImagePath() {
    return imagePath;
  }

  public void setImagePath(String imagePath) {
    this.imagePath = imagePath;
  }

  public String getProductOptionName() {
    return productOptionName;
  }

  public void setProductOptionName(String productOptionName) {
    this.productOptionName = productOptionName;
  }

  public Integer getProductOptionPrice() {
    return productOptionPrice;
  }

  public void setProductOptionPrice(Integer productOptionPrice) {
    this.productOptionPrice = productOptionPrice;
  }

  public String getProductOptionDescription() {
    return productOptionDescription;
  }

  public void setProductOptionDescription(String productOptionDescription) {
    this.productOptionDescription = productOptionDescription;
  }
}
