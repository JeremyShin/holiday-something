package com.holidaysomething.holidaysomething.dto;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "MEMBERS")
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String loginId;

    @OneToMany(mappedBy = "member")
    private Set<MemberCoupon> memberCoupons;

    @OneToMany(mappedBy = "member")
    private Set<ProductQuestion> productQuestions;
}
