package com.holidaysomething.holidaysomething.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

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

  private Integer price;

  private String description;

  //사용자가 신청한 personal 옵션
  private String personalOption;

  @ManyToOne
  @JoinColumn(name = "product_id")
  private Product product;
}
