package com.holidaysomething.holidaysomething.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter @Setter
public class ExchangeRefund {
    private Long id;
    private String type;
    private int price;
    private LocalDateTime applyDate;
    private LocalDateTime allowDate;
    private Boolean allow;
}
