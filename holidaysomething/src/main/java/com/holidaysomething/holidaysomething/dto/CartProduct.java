package com.holidaysomething.holidaysomething.dto;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name="CART_PRODUCTS")
public class CartProduct {

    // @Id 붙이는게 맞나???

    @Id
    @ManyToOne
    @JoinColumn(name = "member_id" , referencedColumnName = "")
    private Long memberId;

    @Id
    @ManyToOne
    @JoinColumn(name = "member_id" , referencedColumnName = "")
    private Long productId;

    @Column(nullable = false)
    private int price;

    @Column(nullable = false)
    private int quantity;
}
