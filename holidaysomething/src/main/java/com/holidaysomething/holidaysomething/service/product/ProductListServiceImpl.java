package com.holidaysomething.holidaysomething.service.product;

import com.holidaysomething.holidaysomething.domain.ProductCategory;
import com.holidaysomething.holidaysomething.dto.ProductListCategoryDto;
import com.holidaysomething.holidaysomething.dto.ProductListImageDto;
import com.holidaysomething.holidaysomething.repository.ProductCategoryRepository;
import com.holidaysomething.holidaysomething.repository.ProductRepository;
import java.util.ArrayList;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/**
 * @author choijaeyong on 25/01/2019.
 * @project holidaysomething
 * @description
 */

@Service
@Slf4j
@RequiredArgsConstructor
public class ProductListServiceImpl implements ProductListService {

  private final ProductRepository productRepository;
  private final ProductCategoryRepository productCategoryRepository;


  @Override
  public ProductListCategoryDto productList(long categoryId, Pageable pageable) {

    ProductCategory pc = productCategoryRepository.findProductCategoryById(categoryId);
    log.info("======= 카테고리 depth 는 " + pc.getDepth() + " 입니다.");

    if (pc.getDepth() == 1) {
      // 대분류. 위에 pc 의 id 만 가져가면 된다.
      // Page<ProductListImageDto> 와 List<String> categoryNames 를 넣을 수 있는
      // Dto 객체를 만들어서 함께 리턴한다.
      Page<ProductListImageDto> productListImageDtoPage =
          productRepository.findProductsImageByCategoryId3(categoryId, pageable);

      log.info(
          "************  productListImageDtoPage.getTotalElements() : " + productListImageDtoPage
              .getTotalElements());
      for (ProductListImageDto productListImageDto : productListImageDtoPage) {
        log.info("**********  리스트 상품아이디 이름 : " + productListImageDto.getProductId() + "     "
            + productListImageDto.getProductName());
      }

      ProductListCategoryDto productListCategoryDto = new ProductListCategoryDto();

      List<ProductCategory> categoryList = new ArrayList<>();

      // home 만들기
      ProductCategory home = new ProductCategory();
      home.setId(0l);
      home.setName("HOME");
      categoryList.add(home);
      categoryList.add(pc);

      productListCategoryDto.setProductListImageDtoPage(productListImageDtoPage);
      productListCategoryDto.setCategoryList(categoryList);

      return productListCategoryDto;
    } else if (pc.getDepth() == 2) {
      // 중분류. 위에 pc 의 id, parentId만 가져가면 된다.

      Page<ProductListImageDto> productListImageDtoPage =
          productRepository.findProductsImageByCategoryId2(categoryId, pageable);

      ProductCategory bigCategory = productCategoryRepository.findProductBigCategory(categoryId);
      ProductListCategoryDto productListCategoryDto = new ProductListCategoryDto();

      List<ProductCategory> categoryList = new ArrayList<>();
      ProductCategory home = new ProductCategory();
      home.setId(0l);
      home.setName("HOME");
      categoryList.add(home);
      categoryList.add(bigCategory);
      categoryList.add(pc);

      productListCategoryDto.setProductListImageDtoPage(productListImageDtoPage);
      productListCategoryDto.setCategoryList(categoryList);

      return productListCategoryDto;
    } else {
      // 소분류.
      Page<ProductListImageDto> productListImageDtoPage =
          productRepository.findProductsImageByCategoryId(categoryId, pageable);

      // 검색결과 위에 보여주는 경로에 필요한 대,중분류 카테고리 검색.
      ProductListCategoryDto productListCategoryDto =
          productCategoryRepository.findProductCategories(categoryId);

      List<ProductCategory> categoryList = new ArrayList<>();
      ProductCategory home = new ProductCategory();
      home.setId(0l);
      home.setName("HOME");
      categoryList.add(home);

      ProductCategory big = new ProductCategory();
      big.setId(productListCategoryDto.getParentId());
      big.setName(productListCategoryDto.getParentName());
      categoryList.add(big);

      ProductCategory middle = new ProductCategory();
      middle.setId(productListCategoryDto.getChildId());
      middle.setName(productListCategoryDto.getChildName());
      categoryList.add(middle);
      categoryList.add(pc);

      productListCategoryDto.setProductListImageDtoPage(productListImageDtoPage);
      productListCategoryDto.setCategoryList(categoryList);

      return productListCategoryDto;
    }
  }


}
