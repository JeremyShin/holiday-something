package com.holidaysomething.holidaysomething.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "EXCHANGE_REFUNDS")
@Getter
@Setter
public class ExchangeRefund {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String type;

    @Column(nullable = false)
    private int price;

    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    private LocalDateTime applyDate;

    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    private LocalDateTime approveDate;

    @Column(nullable = false)
    private Boolean approve;
}