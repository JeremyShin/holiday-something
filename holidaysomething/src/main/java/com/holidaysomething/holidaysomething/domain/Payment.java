package com.holidaysomething.holidaysomething.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "PAYMENTS")
@Getter
@Setter
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 50, nullable = false)
    private String pg;

    @Column(length = 50, nullable = false)
    private String payMethod;

    @Column(nullable = false)
    private String merchantUid;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private int amount;

    @Column(nullable = false)
    private String buyerEmail;

    @Column(nullable = false)
    private String buyerName;

    @Column(nullable = false)
    private String buyerTel;

    @Column(nullable = false)
    private String buyerAddr;

    @Column(nullable = false)
    private String buyerPostcode;

    @Column(nullable = false)
    private String mRedirectUrl;

    @Column(nullable = false)
    private String msg;
}
