package com.holidaysomething.holidaysomething.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "ORDERED_PRODUCT")
@Getter
@Setter
public class OrderedProduct {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(nullable = false)
  private int orderPrice;

  @Column(nullable = false)
  private int mileage;


  @Column(nullable = false)
  private int quantity;

  // 사용자가 신청한 personal 옵션
  private String personalOption;


  @ManyToOne
  @JoinColumn(name = "order_id")
  private Order order;

  @ManyToOne
  @JoinColumn(name = "product_id")
  private Product product;

  @OneToOne
  @JoinColumn(name = "exchange_refund_id")
  private ExchangeRefund exchangeRefund;

}
