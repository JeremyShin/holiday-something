package com.holidaysomething.holidaysomething.dto;

import java.time.LocalDateTime;

public class ProductQuestion {
    private Long id;
    private String title;
    private String body;
    private LocalDateTime regDate;
    private LocalDateTime updateDate;
    private boolean answer;
    private Long memberId;
    private Long productId;
    private Long productQuestionCategoryId;
}
