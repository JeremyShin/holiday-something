package com.holidaysomething.holidaysomething.dto;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
@Entity
@Table(name = "PRODUCT_IMAGES")
@Getter
@Setter
public class ProductImage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String path;
    private String originalFileName;
    private String storedFileName;
    private int size;
    private String fileType;
    private LocalDateTime regDate;
    private LocalDateTime updateDate;

//    @ManyToOne
//    @JoinColumn(name = "product_id")
//    private Product product;
}