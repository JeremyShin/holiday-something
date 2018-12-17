package com.holidaysomething.holidaysomething.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "PRODUCT_CATEGORY")
@Getter
@Setter
@ToString
public class ProductCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "parentId", referencedColumnName = "id", nullable = true)
    private ProductCategory parentProductCategory;

    @OneToMany(mappedBy = "parentProductCategory")
    private List<ProductCategory> productCategories = new ArrayList<>();

    private int orders;

    @OneToMany(mappedBy = "productCategory")
    private Set<Product> products;
}
