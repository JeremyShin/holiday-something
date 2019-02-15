package com.holidaysomething.holidaysomething.domain.constant;

public enum ShippingStatus {
  WAIT_DEPOSIT(1,"입금대기중"),
  COMPLETE_DEPOSIT(2, "입금완료"),
  WAIT_SHIPPING(3, "상품준비중"),
  START_SHIPPING(4, "배송시작"),
  DOING_SHIPPING(5, "배송중"),
  COMPLETE_SHIPPING(6, "배송완료");

  private int code;
  private String description;
  private String description2;

  ShippingStatus(){

  }

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

  public static String getValuesByKey(int key){
    String description = null;

    switch (key){
      case 1: description = WAIT_DEPOSIT.description;
      break;
      case 2: description = COMPLETE_DEPOSIT.description;
      break;
      case 3: description = WAIT_SHIPPING.description;
      break;
      case 4: description = START_SHIPPING.description;
      break;
      case 5: description = DOING_SHIPPING.description;
      break;
      case 6: description = COMPLETE_SHIPPING.description;
      break;
    }
    return description;
  }

}
