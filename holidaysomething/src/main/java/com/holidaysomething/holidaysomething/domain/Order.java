package com.holidaysomething.holidaysomething.domain;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import java.time.LocalDateTime;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

@Entity(name = "ORDERS")
@Table(name = "ORDERS")
@Getter
@Setter
@JsonIdentityInfo(
    generator = ObjectIdGenerators.PropertyGenerator.class,
    property = "id")
public class Order {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(nullable = false)
  private String orderNumber;

  @Column(nullable = false)
  @CreationTimestamp
  private LocalDateTime date;

  @Column(nullable = false)
  private int totalPrice;

  @Column
  private Integer status;

  @Column(columnDefinition = "integer default 0")
  private int mileage;

  @ManyToOne
  @JoinColumn(name = "member_id")
  private Member member;

  @OneToOne
  @JoinColumn(name = "shipping_id")
  private Shipping shipping;

  @OneToOne
  @JoinColumn(name = "payment_id")
  private Payment payment;

  @OneToMany(mappedBy = "order", fetch = FetchType.EAGER)
  private Set<OrderedProduct> orderedProduct;
}