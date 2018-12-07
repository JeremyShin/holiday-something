package com.holidaysomething.holidaysomething.dto;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "ORDERED_PRODUCT")
@Getter
@Setter
public class OrderedProduct {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private int orderPrice;

    @Column(nullable = false)
    private int savedMoney;

    @Column(nullable = false)
    private int quantity;

    @ManyToOne
    @JoinColumn(name = "ordered_product_id")
    private Order order;

    @ManyToOne
    @JoinColumn(name = "ordered_product_id")
    private Long productId;

    @OneToOne
    @JoinColumn(name = "exchange_refund_id")
    private ExchangeRefund exchangeRefund;


    private Long couponId;
}