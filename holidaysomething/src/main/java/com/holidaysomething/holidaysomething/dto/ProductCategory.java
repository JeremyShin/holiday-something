package com.holidaysomething.holidaysomething.dto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class ProductCategory {
    private Long id;
    private String name;
    private Long parentId;
}
