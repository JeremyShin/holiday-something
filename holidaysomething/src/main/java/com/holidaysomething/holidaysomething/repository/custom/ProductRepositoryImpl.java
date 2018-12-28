package com.holidaysomething.holidaysomething.repository.custom;

import com.holidaysomething.holidaysomething.domain.Product;
import com.holidaysomething.holidaysomething.domain.QProduct;
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
      String searchClassificationInput, Pageable pageable) {

    QProduct qProduct = QProduct.product;
    JPQLQuery<Product> jpqlQuery = from(qProduct);
    jpqlQuery.where(qProduct.name.like("%" + searchClassificationInput + "%"));

    List<Product> productList = getQuerydsl().applyPagination(pageable, jpqlQuery).fetch();
    long totalCount = jpqlQuery.fetchCount();

    return new PageImpl<>(productList, pageable, totalCount);
  }
}
