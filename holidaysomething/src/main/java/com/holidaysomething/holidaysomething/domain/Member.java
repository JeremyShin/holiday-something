package com.holidaysomething.holidaysomething.domain;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
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
@JsonIdentityInfo(
    generator = ObjectIdGenerators.PropertyGenerator.class,
    property = "id")
// @JsonIdentityInfo: Bidirectional(양방향) 관계 무한 loop을 방지하기 위함. 반대편 Entity에도 써줘야 한다.
// https://www.baeldung.com/jackson-bidirectional-relationships-and-infinite-recursion
public class Member {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(length = 20, nullable = false, unique = true)
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
  private Integer mileage;

  @Column(nullable = false)
  private LocalDate birthday;

  @Column(length = 20, nullable = false)
  private String postcode;

  @Column(nullable = false)
  private String address1;

  @Column(nullable = false)
  private String address2;

  @Column(nullable = false)
  @CreationTimestamp
  @JsonIgnore
  private LocalDateTime regDate;

  @Column(nullable = false)
  @UpdateTimestamp
  @JsonIgnore
  private LocalDateTime lastLogin;

  @Column(nullable = false)
  @JsonIgnore
  private boolean receiveEmail;

  @Column(nullable = false)
  @JsonIgnore
  private boolean receiveSms;

  @Column(nullable = false)
  @JsonIgnore
  private boolean marketing;

  @Column(nullable = false)
  @JsonIgnore
  private boolean personalInfo;

  @Column(length = 20)
  @JsonIgnore
  private String recommender;

  @Column(length = 10, nullable = false)
  private String sex;

  @OneToMany(mappedBy = "member")
  @JsonIgnore // 마이페이지 메인에서는 일단 필요 없어서 ignore 처리
  private Set<CartProduct> cartProducts;

  //TODO: JsonIgnore 안하면 "Could not write JSON: failed to lazily initialize a collection of role~" 에러 발생
  //TODO: JsonIgnore 하면 위의 에러는 발생하지 않지만 orders에 데이터가 안들어감

  // Eager loading을 하면 member를 조회하는 순간 order 내부까지 다 조회해서 포함된다.
  // TODO : FetchType.EAGER 일 경우 MemberRepository.findAll() 을 할 경우 Query 가 너무 많이 발생합니다...(LAZY 일 경우 1번만 select 함)
  @OneToMany(mappedBy = "member", fetch = FetchType.EAGER)
  private List<Order> orders;

  @ManyToMany
  @JoinTable(name = "member_role",
      joinColumns = @JoinColumn(name = "member_id", referencedColumnName = "id"),
      inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id"))
  @JsonIgnore // 마이페이지 메인에서는 일단 필요 없어서 ignore 처리
  private Set<Role> roles;
}
