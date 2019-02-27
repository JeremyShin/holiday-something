package com.holidaysomething.holidaysomething.service.product;

import com.holidaysomething.holidaysomething.dto.ProductListCategoryDto;
import com.holidaysomething.holidaysomething.dto.ProductListImageDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * @author choijaeyong on 25/01/2019.
 * @project holidaysomething
 */
public interface ProductListService {

  // 유저화면 소분류 카테고리 클릭 -> 상품리스트 화면.
  ProductListCategoryDto productList(long categoryId, Pageable pageable);
}
