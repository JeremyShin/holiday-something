package com.holidaysomething.holidaysomething.dto;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Table(name="PRODUCT_REVIEW_IMAGES")
public class ProductReviewImage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String path;

    @Column(nullable = false)
    private String originalFileName;

    @Column(nullable = false)
    private String storedFileName;

    // 파일 크기 인데. int 로 될까??
    @Column(nullable = false)
    private int size;

    @Column(nullable = false)
    private String fileType;

    @CreationTimestamp
    @Column(nullable = false)
    private LocalDateTime regDate;

    @UpdateTimestamp
    @Column(nullable = false)
    private LocalDateTime updateDate;

    @ManyToOne
    @JoinColumn(name="product_review_id", referencedColumnName = "id")
    private Long productReviewId;
}
