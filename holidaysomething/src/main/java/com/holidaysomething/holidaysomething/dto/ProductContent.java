package com.holidaysomething.holidaysomething.dto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class ProductContent {
    private Long productId;
    private Long contentId;
}
// TODO 공용키 외에 추가적으로 필요한 컬럼이 없을 경우 따로 도메인을 만들어 줄 필요가 없다고 생각!