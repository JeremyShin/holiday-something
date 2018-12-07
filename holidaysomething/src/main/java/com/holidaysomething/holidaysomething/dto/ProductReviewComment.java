package com.holidaysomething.holidaysomething.dto;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name="PRODUCT_REVIEW_COMMENTS")
public class ProductReviewComment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Lob
    private String body;

    @ManyToOne
    @JoinColumn(name="member_id",referencedColumnName = "")
    private Long memberId;

    @ManyToOne
    @JoinColumn(name="product_review_id", referencedColumnName = "id")
    private Long productReviewId;
}
