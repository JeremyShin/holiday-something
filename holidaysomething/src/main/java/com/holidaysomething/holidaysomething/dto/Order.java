package com.holidaysomething.holidaysomething.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class Order {
    private Long id;
    private String orderNumber;
    private LocalDateTime date;
    private int totalPrice;
    private String status;
    private int savedMoney;
    private Long memberId;
    private Long shippingId;
    private Long paymentId;
    private Long nonmemerId;
}
