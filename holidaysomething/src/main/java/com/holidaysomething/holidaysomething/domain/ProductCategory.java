package com.holidaysomething.holidaysomething.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "PRODUCT_CATEGORIES")
@Getter
@Setter
public class ProductCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Long parentId;  // TODO : Long일 필요가 있을까?

//    @OneToMany
//    private Set<Product> products;
}
