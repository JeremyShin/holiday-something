package com.holidaysomething.holidaysomething.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
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
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Getter
@Setter
@Entity
@Table(name = "MEMBER")
public class Member {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(length = 50, nullable = false, unique = true)
  private String loginId;

  @Column(nullable = false)
  private String password;

  @Column(nullable = false, unique = true)
  private String email;

  @Column(length = 20, nullable = false)
  private String name;

  @Column(length = 50, nullable = false, unique = true)
  private String nickname;

  @Column(length = 50, nullable = false, unique = true)
  private String phone;

  @Column(columnDefinition = "integer default 0")
  private int mileage;

  @Column(nullable = false)
  private Date birthday;

  @Column(length = 20, nullable = false)
  private String postcode;

  @Column(nullable = false)
  private String address1;

  @Column(nullable = false)
  private String address2;

  @Column(nullable = false)
  @CreationTimestamp
  private LocalDateTime regDate;

  @Column(nullable = false)
  @UpdateTimestamp
  private LocalDateTime lastLogin;

  @Column(nullable = false)
  private boolean receiveEmail;

  @Column(nullable = false)
  private boolean receiveSms;

  @Column(nullable = false)
  private boolean marketing;

  @Column(nullable = false)
  private boolean personalInfo;

  @Column(length = 20)
  private String recommender;

  @Column(length = 10, nullable = false)
  private String sex;

  @OneToMany(mappedBy = "member")
  @JsonIgnore // ignore하지 않을 경우 순환참조(무한 재귀; Infinite recursion) 발생
  private Set<CartProduct> cartProducts;

  @OneToMany(mappedBy = "member")
  @JsonIgnore // ignore하지 않을 경우 순환참조(무한 재귀; Infinite recursion) 발생
  private List<Order> orders;
}
