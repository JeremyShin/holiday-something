package com.holidaysomething.holidaysomething.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter @Setter
public class ProductImage {
    private Long id;
    private String path;
    private String originalFileName;
    private String storedFileName;
    private int size;
    private String fileType;
    private LocalDateTime regDate;
    private LocalDateTime updateDate;
    private Long productId;
}
