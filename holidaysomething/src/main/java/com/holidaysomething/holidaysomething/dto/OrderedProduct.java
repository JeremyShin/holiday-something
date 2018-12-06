package com.holidaysomething.holidaysomething.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderedProduct {
    private Long id;
    private int orderPrice;
    private int savedMoney;
    private int quantity;
    private Long orderId;
    private Long pruductId;
    private Long exchangeRefundId;
    private Long couponId;
}
