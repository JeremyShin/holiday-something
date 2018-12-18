package com.holidaysomething.holidaysomething.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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


  private Long parentId;

//     @ManyToOne(cascade = CascadeType.ALL)
//     @JoinColumn(name = "parentId", referencedColumnName = "id", nullable = true)
//     private ProductCategory parentProductCategory;

//     @OneToMany(mappedBy = "parentProductCategory")
//     private List<ProductCategory> productCategories = new ArrayList<>();

  private int orders;

  @OneToMany(mappedBy = "productCategory")
  @Column(nullable = true)
  @JsonIgnore
  @JsonIgnoreProperties
  private Set<Product> products;


}

/*
    Set<Product> products 가 있으면 JSON 객체가 안만들어진다...?? 하아
 */



/*

사실 DTO가 사용된 이유는 Entity bean을 serialize해서 client로 보낼 방법이 없었기 때문이다.
거의 비슷한 setter/getter를 가진 DTO를 Entity bean과 별도로 만들고 일일히 프로퍼티를 카피해주는
그런 코드들을 사용할 수 밖에 없었다. 솔직이 짜증나는 짓이었다.
물론 좀 편하게 reflection등을 이용해서 bean property를 카피해주는 기술도 사용되었지만
 성능상의 문제로 인해 사용이 기피되기도 했다.
 */