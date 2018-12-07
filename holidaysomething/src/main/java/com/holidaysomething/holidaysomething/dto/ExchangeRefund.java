package com.holidaysomething.holidaysomething.dto;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "EXCHANGE_REFUND")
@Getter
@Setter
public class ExchangeRefund {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 255, nullable = false)
    private String type;

    @Column(nullable = false)
    private int price;

    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    private LocalDateTime applyDate;

    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    private LocalDateTime allowDate;

    @Column(nullable = false)
    private Boolean allow;

    @OneToOne
    @JoinColumn(name = "EXCHANGE_REFUND_DETAIL_ID")
    private ExchangeRefundDetail exchangeRefundDetail;
}