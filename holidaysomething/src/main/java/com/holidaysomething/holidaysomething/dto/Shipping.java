package com.holidaysomething.holidaysomething.dto;

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

    @Column(length = 255, nullable = false)
    private String recipient;

    @Column(length = 255, nullable = false)
    private String phone;

    @Column(length = 50, nullable = false)
    private String zipcode;

    @Column(length = 255, nullable = false)
    private String address;

    @Column(length = 255, nullable = false)
    private String addressDetail;

    @Column(length = 255, nullable = false)
    private String message;

    @Column(nullable = false)
    private int shippingPrice;

    @Column(length = 50, nullable = false)
    private String shippingNumber;

    @Column(length = 50, nullable = false)
    private String status;

    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    private LocalDateTime startDate;

    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    private LocalDateTime arrivalDate;

    @OneToOne
    @JoinColumn(name = "COMPANY_ID")
    private ShippingCompany shippingCompany;
}