package com.holidaysomething.holidaysomething.repository;

import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.core.types.dsl.Expressions;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class ProductPredicatesBuilder {

  private List<SearchCriteria> params;

  public ProductPredicatesBuilder() {
    params = new ArrayList<>();
  }

  public ProductPredicatesBuilder with(String key, String operation, Object value) {

    params.add(new SearchCriteria(key, operation, value));
    return this;
  }

  public BooleanExpression build() {
    if (params.size() == 0) {
      return null;
    }

    List<BooleanExpression> predicates = params.stream().map(param -> {
      ProductPredicate predicate = new ProductPredicate(param);
      return predicate.getPredicate();
    }).filter(Objects::nonNull).collect(Collectors.toList());

    BooleanExpression result = Expressions.asBoolean(true).isTrue();
    for (BooleanExpression predicate : predicates) {
      result = result.and(predicate);
    }
    return result;
  }
}
