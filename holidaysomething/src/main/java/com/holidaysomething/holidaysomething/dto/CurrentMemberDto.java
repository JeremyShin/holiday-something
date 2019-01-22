package com.holidaysomething.holidaysomething.dto;

import java.time.LocalDateTime;

public class CurrentMemberDto {

  private Long memberId;
  private String name;
  private String nickname;
  private int mileage;
  private Long orderId;
  private String orderNumber;
  private LocalDateTime regDate;
  private int totalPrice;
  private Long productId;
  private String productName;
  private String imagePath;

  public CurrentMemberDto(Long memberId, String name, String nickname, int mileage,
      Long orderId, String orderNumber, LocalDateTime regDate, int totalPrice, Long productId,
      String productName, String imagePath) {
    this.memberId = memberId;
    this.name = name;
    this.nickname = nickname;
    this.mileage = mileage;
    this.orderId = orderId;
    this.orderNumber = orderNumber;
    this.regDate = regDate;
    this.totalPrice = totalPrice;
    this.productId = productId;
    this.productName = productName;
    this.imagePath = imagePath;
  }

  public Long getMemberId() {
    return memberId;
  }

  public void setMemberId(Long memberId) {
    this.memberId = memberId;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getNickname() {
    return nickname;
  }

  public void setNickname(String nickname) {
    this.nickname = nickname;
  }

  public int getMileage() {
    return mileage;
  }

  public void setMileage(int mileage) {
    this.mileage = mileage;
  }

  public Long getOrderId() {
    return orderId;
  }

  public void setOrderId(Long orderId) {
    this.orderId = orderId;
  }

  public String getOrderNumber() {
    return orderNumber;
  }

  public void setOrderNumber(String orderNumber) {
    this.orderNumber = orderNumber;
  }

  public LocalDateTime getDate() {
    return regDate;
  }

  public void setDate(LocalDateTime regDate) {
    this.regDate = regDate;
  }

  public int getTotalPrice() {
    return totalPrice;
  }

  public void setTotalPrice(int totalPrice) {
    this.totalPrice = totalPrice;
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

  public String getImagePath() {
    return imagePath;
  }

  public void setImagePath(String imagePath) {
    this.imagePath = imagePath;
  }
}
