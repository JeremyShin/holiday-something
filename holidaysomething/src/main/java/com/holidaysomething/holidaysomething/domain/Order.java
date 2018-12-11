package com.holidaysomething.holidaysomething.domain;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "ORDERS")
@Getter
@Setter
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String orderNumber;

    @Column(nullable = false)
    @CreationTimestamp
    private LocalDateTime date;

    @Column(nullable = false)
    private int totalPrice;

    @Column(nullable = false)
    private String status;

    @Column(columnDefinition = "integer default 0")
    private int mileage;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;

    @OneToOne
    @JoinColumn(name = "shipping_id")
    private Shipping shipping;

    @OneToOne
    @JoinColumn(name = "payment_id")
    private Payment payment;
}
