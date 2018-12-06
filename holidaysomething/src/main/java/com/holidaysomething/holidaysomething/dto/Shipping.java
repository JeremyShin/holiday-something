package com.holidaysomething.holidaysomething.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class Shipping {
    private Long id;
    private String recipient;
    private String phone;
    private String zipcode;
    private String address;
    private String addressDetail;
    private String message;
    private int shippingPrice;
    private String shippingNumber;
    private String status;
    private LocalDateTime startDate;
    private LocalDateTime arrivalDate;
    private Long companyId;
}
