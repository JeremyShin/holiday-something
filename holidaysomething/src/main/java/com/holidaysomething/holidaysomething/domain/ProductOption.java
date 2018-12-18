package com.holidaysomething.holidaysomething.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "PRODUCT_OPTION")
@Getter
@Setter
@ToString
public class ProductOption {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(nullable = false)
  private String name;

    @Lob
    private String description;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;
  
    private Integer price;

}
