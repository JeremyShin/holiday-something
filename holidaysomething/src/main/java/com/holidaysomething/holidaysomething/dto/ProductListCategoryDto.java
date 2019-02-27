package com.holidaysomething.holidaysomething.dto;

import com.holidaysomething.holidaysomething.domain.ProductCategory;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.domain.Page;

/**
 * @author choijaeyong on 27/01/2019.
 * @project holidaysomething User 페이지에서 카테고리를 검색 조건으로 해서 해당 카테고리의 상품 리스트를 불러올 때 필요한 DTO.
 */
@Setter
@Getter
public class ProductListCategoryDto {

  private Page<ProductListImageDto> productListImageDtoPage;
  private List<ProductCategory> categoryList;
  private Long parentId;
  private String parentName;
  private Long childId;
  private String childName;

  public ProductListCategoryDto() {
  }

  // 소분류에서 대,중 분류 불러올 때 사용.
  public ProductListCategoryDto(Long childId, String childName, Long parentId, String parentName) {
    this.parentId = parentId;
    this.parentName = parentName;
    this.childId = childId;
    this.childName = childName;
  }
}
