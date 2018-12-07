package com.holidaysomething.holidaysomething.dto;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name="WISH_PRODUCTS")
public class WishProduct {
    @Id
    @ManyToOne
    @JoinColumn(name = "member_id" , referencedColumnName = "")
    private Long memberId;

    @Id
    @ManyToOne
    @JoinColumn(name = "product_id" , referencedColumnName = "")
    private Long productId;
}
