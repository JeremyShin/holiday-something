package com.holidaysomething.holidaysomething.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "PRODUCT_OPTIONS")
@Getter
@Setter
public class ProductOption {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    private Integer price;

    //사용자가 신청한 personal 옵션
    private String personalOption;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;
}
