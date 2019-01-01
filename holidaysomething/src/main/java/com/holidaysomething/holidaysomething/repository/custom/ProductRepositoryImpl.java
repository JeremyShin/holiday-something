package com.holidaysomething.holidaysomething.repository.custom;

import com.holidaysomething.holidaysomething.domain.Product;
import com.holidaysomething.holidaysomething.domain.QProduct;
import com.holidaysomething.holidaysomething.domain.QProductCategory;
import com.querydsl.jpa.JPAExpressions;
import com.querydsl.jpa.JPQLQuery;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

@Slf4j
public class ProductRepositoryImpl extends QuerydslRepositorySupport implements
    ProductRepositoryCustom {

  public ProductRepositoryImpl() {
    super(Product.class);
  }

  @Override
  public Page<Product> findProducts(String searchClassificationValue,
      String searchClassificationInput, Long largeId, Long middleId, Long smallId,
      String dateValue, String startDateSelect, String endDateSelect, Pageable pageable) {

    QProduct qProduct = QProduct.product;
    QProductCategory qProductCategory = QProductCategory.productCategory;
    JPQLQuery<Product> jpqlQuery = from(qProduct);

    // 검색 분류
    if (searchClassificationValue != null && !searchClassificationInput.equals("")) {
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
    if (largeId != null) {
      if (middleId != null) {
        if (smallId != null) {  // 대분류, 중분류, 소분류까지 선택
          jpqlQuery.where(qProduct.productCategory.id.eq(smallId));
        } else {  // 대분류, 중분류까지 선택
          jpqlQuery.where(qProduct.productCategory.id.eq(middleId));
        }
      } else { // 대분류만 선택
        jpqlQuery
            // largeId와 대분류 id가 같거나
            .where(qProduct.productCategory.id.eq(largeId)
                // id가 largeId인 category를 parent로 갖는 자식 카테고리(중분류까지)
                .or(qProduct.productCategory.parentId.eq(largeId)
                    .and(qProduct.productCategory.id.eq(qProductCategory.id)))
                // id가 largeId인 category를 parent로 갖는 자식 카테고리를 parent로 갖는 자식 카테고리(소분류까지)
                /* SELECT * FROM product
                WHERE product_category_id IN (SELECT id FROM product_category WHERE parent_id IN (SELECT id FROM product_category WHERE parent_id = 1)); */
                .or(qProductCategory.id
                    .in(JPAExpressions.select(qProductCategory.id).from(qProductCategory)
                        .where(qProductCategory.parentId
                            .in(JPAExpressions.select(qProductCategory.id).from(qProductCategory)
                                .where(qProductCategory.parentId.eq(largeId)))))))
            // 결과를 product의 id의 오름차순으로 정렬
            .orderBy(qProduct.id.asc());
      }
    }
    // 날짜 분류
    if (dateValue != null && !startDateSelect.equals("")) {
      LocalDateTime startLocalDateTime = LocalDateTime
          .parse(startDateSelect + " 00:00:00", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
      LocalDateTime endLocalDateTime = LocalDateTime
          .parse(endDateSelect + " 23:59:59", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
      log.info("startLocalDateTime: " + startLocalDateTime);
      log.info("endLocalDateTime: " + endLocalDateTime);

      // 상품 제조일
      if (dateValue.equals("manufactureDate")) {
        jpqlQuery.where(qProduct.manufactureDate.between(startLocalDateTime, endLocalDateTime));
      }
      // 상품 출시일
      else if (dateValue.equals("releaseDate")) {
        jpqlQuery.where(qProduct.releaseDate.between(startLocalDateTime, endLocalDateTime));
      }
    }

    // 최종 검색 결과
    List<Product> productList = getQuerydsl().applyPagination(pageable, jpqlQuery).fetch();
    long totalCount = jpqlQuery.fetchCount();

    log.info("총 " + productList.size() + "개 product 조회 결과");
    log.info("==============================");
    for (Product product : productList) {
      log.info(product.getId().toString());
      log.info(product.getName());
      log.info(product.getCode());
      log.info(product.getProductCategory().getName());
      log.info(product.getManufacturer());
      log.info(product.getManufactureDate().toString());
      log.info(product.getRegDate().toString());
      log.info("==============================");
    }

    return new PageImpl<>(productList, pageable, totalCount);
  }
}
