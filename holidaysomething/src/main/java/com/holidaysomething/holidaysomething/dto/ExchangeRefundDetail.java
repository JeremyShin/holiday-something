package com.holidaysomething.holidaysomething.dto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class ExchangeRefundDetail {
    private Long id;
    private String category;
    private String customerReason;
    private String answer;
    private Long exchangeRefundId;
}
