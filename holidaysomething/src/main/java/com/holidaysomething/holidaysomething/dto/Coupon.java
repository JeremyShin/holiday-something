package com.holidaysomething.holidaysomething.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class Coupon {
    private Long id;
    private String name;
    private Float discountRate;
    private String imageUrl;
    private int quantity;
    private LocalDateTime startDate;
    private LocalDateTime expireDate;
    private int discountPrice;
    private int minimumPrice;
}