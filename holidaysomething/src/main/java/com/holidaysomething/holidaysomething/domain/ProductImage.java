package com.holidaysomething.holidaysomething.domain;

import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name = "PRODUCT_IMAGE")
@Getter
@Setter
public class ProductImage {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private Long category;

  private String path;

  @Column(nullable = false)
  private String originalFileName;

  @Column(nullable = false)
  private String storedFileName;


  @Column(nullable = false)
  private int size;

  @Column(nullable = false)
  private String fileType;

  @Column(nullable = false)
  @CreationTimestamp
  private LocalDateTime regDate;

  @UpdateTimestamp
  private LocalDateTime updateDate;

  @ManyToOne
  @JoinColumn(name = "product_id")
  private Product product;
}