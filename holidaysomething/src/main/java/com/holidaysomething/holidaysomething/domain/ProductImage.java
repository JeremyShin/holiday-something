package com.holidaysomething.holidaysomething.domain;

import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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

// TODO : storedFileName에 경로도 같이 저장하면 불러오기가 편한데 사용한 곳이 있는 것 같다...
  private String path;

  @Column(nullable = false)
  private String originalFileName;

  @Column(nullable = false)
  private String storedFileName;

  @Column(nullable = false)
  private Long size;

  @Column(nullable = false)
  private String fileType;

  @Column(nullable = false)
  @CreationTimestamp
  private LocalDateTime regDate;

//  TODO : 필요없어보이는데... 샘플 SQL을 고칠까??
  @UpdateTimestamp
  private LocalDateTime updateDate;

  @ManyToOne
  @JoinColumn(name = "product_id")
  private Product product;
}