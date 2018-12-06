package com.holidaysomething.holidaysomething.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter @Setter
public class Content {
    private Long id;
    private String title;
    private LocalDateTime regDate;
    private LocalDateTime updateDate;
    private Long contentCategoryId;
}
