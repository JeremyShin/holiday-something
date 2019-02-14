package com.holidaysomething.holidaysomething.domain.constant;

public enum ShippingStatus {
  WAIT_DEPOSIT(1,"입금대기중"),
  COMPLETE_DEPOSIT(2, "입금완료", "상품준비중"),
  START_SHIPPING(3, "배송시작"),
  DOING_SHIPPING(4, "배송중"),
  COMPLETE_SHIPPING(5, "배송완료");

  private int code;
  private String description;
  private String description2;

  ShippingStatus(int code, String description) {
    this.code = code;
    this.description = description;
  }

  ShippingStatus(int code, String description, String description2) {
    this.code = code;
    this.description = description;
    this.description2 = description2;
  }

  public int getCode() {
    return this.code;
  }

  public String getDescription() {
    return this.description;
  }

  public String getDescription2() {
    return this.description2;
  }
}
