package com.holidaysomething.holidaysomething.controller.user.product;

import com.holidaysomething.holidaysomething.dto.ProductListImageDto;
import com.holidaysomething.holidaysomething.service.product.ProductListService;
import com.holidaysomething.holidaysomething.service.product.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author choijaeyong on 25/01/2019.
 * @project holidaysomething
 * @description
 */
@RestController
@RequestMapping("/product")
@RequiredArgsConstructor
@Slf4j
public class ProductListRestController {

  private final ProductListService productListService;

  // 소분류 카테고리 눌렀을 때 조회돼야 하는 상품 리슷트!
  @RequestMapping("/{categoryId}")
  public ResponseEntity productList(@PathVariable("categoryId") Long categoryId,
      @PageableDefault(size = 5, sort = "name", direction = Direction.ASC) Pageable pageable) {
    ResponseEntity entity = null;
    try {
      entity = new ResponseEntity(productListService.productList(categoryId, pageable),
          HttpStatus.OK);
    } catch (Exception e) {
      e.printStackTrace();
      entity = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    return entity;
  }


}
