package com.holidaysomething.holidaysomething.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "PRODUCT_CATEGORY")
@Getter
@Setter
public class ProductCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    private Long parentId;

    private int orders;

    @OneToMany(mappedBy = "productCategory")
    private Set<Product> products;
}
