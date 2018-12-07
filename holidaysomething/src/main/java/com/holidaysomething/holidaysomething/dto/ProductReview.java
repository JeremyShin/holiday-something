package com.holidaysomething.holidaysomething.dto;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name="PRODUCT_REVIEWS")
public class ProductReview {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String title;

    @Lob
    private String body;

    @CreationTimestamp
    @Column(nullable = false)
    private LocalDateTime regDate;

    @UpdateTimestamp
    @Column(nullable = false)
    private LocalDateTime updateDate;


    @Column(nullable = false)
    private Float rate;

    @ManyToOne
    @JoinColumn(name="member_id",referencedColumnName = "")
    private Long memberId;

    @ManyToOne
    @JoinColumn(name="product_id",referencedColumnName = "")
    private Long productId;


    // Image List 를 가지고 있어야 하지 않나?
    @OneToMany
    private List<ProductReviewImage> productReviewImages;
}
