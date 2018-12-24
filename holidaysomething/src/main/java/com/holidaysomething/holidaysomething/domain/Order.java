package com.holidaysomething.holidaysomething.domain;

import java.time.LocalDateTime;
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
import org.hibernate.annotations.CreationTimestamp;

@Entity(name = "ORDERS")
@Table(name = "ORDERS")
@Getter
@Setter
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

  @Column(nullable = false)
  private String status;

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
}
