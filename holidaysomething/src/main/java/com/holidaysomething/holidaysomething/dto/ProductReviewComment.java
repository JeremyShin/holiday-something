package com.holidaysomething.holidaysomething.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductReviewComment {
    private Long id;
    private String body;
    private Long memberId;
    private Long productReviewId;
}
