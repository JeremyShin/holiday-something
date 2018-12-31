package com.holidaysomething.holidaysomething.repository.custom;

import com.holidaysomething.holidaysomething.domain.Product;
import com.holidaysomething.holidaysomething.domain.QProduct;
import com.holidaysomething.holidaysomething.domain.QProductCategory;
import com.querydsl.jpa.JPQLQuery;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

public class ProductRepositoryImpl extends QuerydslRepositorySupport implements ProductRepositoryCustom {

  public ProductRepositoryImpl() {
    super(Product.class);
  }

  @Override
  public Page<Product> findProducts(String searchClassificationValue,
      String searchClassificationInput, Long largeId, Long middleId, Long smallId,
      String searchDateValue, String startDateSelect, String endDateSelect, Pageable pageable) {

    QProduct qProduct = QProduct.product;
    QProductCategory qProductCategory = QProductCategory.productCategory;
    JPQLQuery<Product> jpqlQuery = from(qProduct);

    // 검색 분류
    if (!searchClassificationValue.equals("") && !searchClassificationInput.equals("")) {
      switch (searchClassificationValue) {
        case "productName":
          jpqlQuery.where(qProduct.name.like("%" + searchClassificationInput + "%"));
          break;
        case "productCode":
          jpqlQuery.where(qProduct.code.eq(searchClassificationInput));
          break;
        case "productSellingPrice":
          jpqlQuery.where(qProduct.sellingPrice.eq(Integer.parseInt(searchClassificationInput)));
          break;
        case "productManufacturer":
          jpqlQuery.where(qProduct.manufacturer.like("%" + searchClassificationInput + "%"));
          break;
        case "productOptionalPriceText":
          jpqlQuery.where(qProduct.optionalPriceText.like("%" + searchClassificationInput + "%"));
          break;
        case "productShippingPrice":
          jpqlQuery.where(qProduct.shippingPrice.eq(Integer.parseInt(searchClassificationInput)));
          break;
      }
    }
    // 상품 분류
    if (largeId != 0L) {
      if (middleId != 0L) {
        if (smallId != 0L) {  // 대분류, 중분류, 소분류까지 선택
          jpqlQuery.where(qProduct.productCategory.id.eq(smallId));
        }
        else {  // 대분류, 중분류까지 선택
          jpqlQuery.where(qProduct.productCategory.id.eq(middleId));
        }
      }
      else { // 대분류만 선택
        jpqlQuery
            // largeId와 대분류 id가 같거나
            .where(qProduct.productCategory.id.eq(largeId)
            // id가 largeId인 category를 parent로 갖는 자식 카테고리(중분류까지)
            .or(qProduct.productCategory.parentId.eq(largeId).and(qProduct.productCategory.id.eq(qProductCategory.id)))
            // id가 largeId인 category를 parent로 갖는 자식 카테고리를 parent로 갖는 자식 카테고리(소분류까지)
            /*
            select * from product
            where product_category_id IN (select id from product_category where parent_id IN (select id from product_category where parent_id = 1));
             */
            /**.or())**/)
            // 결과를 product의 id의 오름차순으로 정렬
            .orderBy(qProduct.id.asc());
      }
    }
    // 상품 등록일 ・ 상품 출시일
    if (!searchDateValue.equals("") && !startDateSelect.equals("")) {

    }

    List<Product> productList = getQuerydsl().applyPagination(pageable, jpqlQuery).fetch();
    long totalCount = jpqlQuery.fetchCount();

    return new PageImpl<>(productList, pageable, totalCount);
  }
}
