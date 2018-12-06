package com.holidaysomething.holidaysomething.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CartProduct {
    private Long memberId;
    private Long productId;
    private int price;
    private int quantity;
}
