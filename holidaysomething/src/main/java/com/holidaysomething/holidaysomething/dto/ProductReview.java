package com.holidaysomething.holidaysomething.dto;

import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;

@Getter
@Setter
public class ProductReview {
    private Long id;
    private String title;
    private String body;
    private LocalDateTime regDate;
    private LocalDateTime updateDate;
    private Float rate;
    private Long memberId;
    private Long productId;
}
