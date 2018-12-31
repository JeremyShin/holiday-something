package com.holidaysomething.holidaysomething.service.admin;

import com.holidaysomething.holidaysomething.domain.ProductOption;
import com.holidaysomething.holidaysomething.domain.ProductOptionCommand;
import java.util.List;

public interface AdminProductOptionService {

  // ProductOptionCommand 를 ProductOption 의 리스트로 바꾸어주는 메소드
  List<ProductOption> fromProductOptionCommandToProductOptionList(ProductOptionCommand poc);

  // ProductOption 리스트를 하나씩 db에 insert 하는 메소드
  void save(List<ProductOption> productOptions, Long productId);
}
