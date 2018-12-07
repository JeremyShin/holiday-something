package com.holidaysomething.holidaysomething.dto;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "COUPONS")
public class Coupon {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    private Float discountRate;
    private String imageUrl;

    @Column(nullable = false)
    private int quantity;

    private LocalDateTime startDate;
    private LocalDateTime expireDate;
    private int discountPrice;
    private int minimumPrice;

    @OneToMany(mappedBy = "coupon")
    private Set<MemberCoupon> memberCoupons;

    @OneToMany(mappedBy = "coupon")
    private Set<ProductCounpon> productCounpons;

}