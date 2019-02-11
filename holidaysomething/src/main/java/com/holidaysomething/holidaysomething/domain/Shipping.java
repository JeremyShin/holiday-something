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
@Table(name = "SHIPPING")
@Getter
@Setter
public class Shipping {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(nullable = false)
  private String recipient;

  @Column(nullable = false)
  private String phone;

  @Column(length = 50, nullable = false)
  private String postcode;

  @Column(nullable = false)
  private String address;

  @Column(nullable = false)
  private String addressDetail;

  @Column
  private String message;

  @Column(nullable = false)
  private int shippingPrice;

  @Column(length = 50, nullable = false)
  private String shippingNumber;

  private LocalDateTime startDate;
  private LocalDateTime arrivalDate;
}