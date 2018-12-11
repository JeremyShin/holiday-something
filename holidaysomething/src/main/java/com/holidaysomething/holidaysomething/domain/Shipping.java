package com.holidaysomething.holidaysomething.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "SHIPPING")
@Getter
@Setter
public class Shipping {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String recipient;

    @Column(nullable = false)
    private String phone;

    @Column(length = 50, nullable = false)
    private String postcode;

    @Column(nullable = false)
    private String address;

    @Column(nullable = false)
    private String addressDetail;

    @Column(nullable = false)
    private String message;

    @Column(nullable = false)
    private int shippingPrice;

    @Column(length = 50, nullable = false)
    private String shippingNumber;

    @Column(length = 50, nullable = false)
    private String status;

    private LocalDateTime startDate;
    private LocalDateTime arrivalDate;
}