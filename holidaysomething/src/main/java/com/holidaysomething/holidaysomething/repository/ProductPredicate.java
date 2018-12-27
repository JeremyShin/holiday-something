package com.holidaysomething.holidaysomething.repository;

import static org.hibernate.query.criteria.internal.ValueHandlerFactory.isNumeric;

import com.holidaysomething.holidaysomething.domain.Product;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.core.types.dsl.NumberPath;
import com.querydsl.core.types.dsl.PathBuilder;
import com.querydsl.core.types.dsl.StringPath;

public class ProductPredicate {

  private SearchCriteria criteria;

  public ProductPredicate(SearchCriteria criteria) {
    this.criteria = criteria;
  }

  public BooleanExpression getPredicate() {
    PathBuilder<Product> entityPath = new PathBuilder<>(Product.class, "product");

    if (isNumeric(criteria.getValue().toString())) {
      NumberPath<Integer> path = entityPath.getNumber(criteria.getKey(), Integer.class);
      int value = Integer.parseInt(criteria.getValue().toString());
      switch (criteria.getOperation()) {
        case ":":
          return path.eq(value);
        case ">":
          return path.goe(value);
        case "<":
          return path.loe(value);
      }
    }
    else {
      StringPath path = entityPath.getString(criteria.getKey());
      if (criteria.getOperation().equalsIgnoreCase(":")) {
        return path.containsIgnoreCase(criteria.getValue().toString());
      }
    }
    return null;
  }
}
