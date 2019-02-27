package com.holidaysomething.holidaysomething.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

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

  // TODO: 대중소 id를 각각 다 갖고 있는 것이 효율적 (불필요한 서브쿼리 방지)
  private Long parentId;

  private int orders;

  @OneToMany(mappedBy = "productCategory")
  @JsonIgnore
  @JsonIgnoreProperties
  private Set<Product> products = new HashSet<>();

  private int depth;
}