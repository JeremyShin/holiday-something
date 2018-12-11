package com.holidaysomething.holidaysomething.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "EXCHANGE_REFUND")
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
    private LocalDateTime applyDate;

    @Column(nullable = false)
    private LocalDateTime approveDate;

    @Column(nullable = false)
    private Boolean approve;
}