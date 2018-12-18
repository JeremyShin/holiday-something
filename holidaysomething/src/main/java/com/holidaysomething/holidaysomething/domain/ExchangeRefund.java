package com.holidaysomething.holidaysomething.domain;

import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "EXCHANGE_REFUND")
@Getter
@Setter
public class ExchangeRefund {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(nullable = false)
  private String type;

  @Column(nullable = false)
  private int price;

  @Column(nullable = false)
  private LocalDateTime applyDate;

  @Column(nullable = false)
  private LocalDateTime approveDate;

  @Column(nullable = false)
  private Boolean approve;
}