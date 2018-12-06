package com.holidaysomething.holidaysomething.dto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class ContentCategory {
    private Long id;
    private String name;
    private Long parentId;
}
