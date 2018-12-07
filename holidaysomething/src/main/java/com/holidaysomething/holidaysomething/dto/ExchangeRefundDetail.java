package com.holidaysomething.holidaysomething.dto;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "EXCHANGE_REFUND_DETAIL")
@Getter
@Setter
public class ExchangeRefundDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 255, nullable = false)
    private String category;

    @Column(nullable = false)
    private String customerReason;

    @Column(nullable = false)
    private String answer;
}