package com.holidaysomething.holidaysomething.service.product;

import com.holidaysomething.holidaysomething.domain.ProductOption;
import com.holidaysomething.holidaysomething.dto.ProductOptionCommand;
import com.holidaysomething.holidaysomething.dto.ProductOrderDetailDto;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ProductOptionService {

  List<ProductOption> getAllProductOptions();

  List<ProductOption> getProductOptionsByProductId(Long productId);

  ProductOption getProductOption(Long id);

  ProductOrderDetailDto getProductOptionForOrder(Long id);

  void deleteProductOption(Long id);

  void save(ProductOption productOption);

  Page<ProductOption> getAllProductOptionsPage(Pageable pageable);

  Page<ProductOption> getAllProductOptionsByNamePage(String name, Pageable pageable);

  Page<ProductOption> getAllProductOptionsByDescriptionPage(String productOptionSearchValue,
      Pageable pageable);

  Page<ProductOption> getAllProductOptionsByPricePage(String productOptionSearchValue,
      Pageable pageable);

  Page<ProductOption> getProductOptionsByProductId(Long productId, Pageable pageable);

  // ProductOptionCommand 를 ProductOption 의 리스트로 바꾸어주는 메소드
  List<ProductOption> fromProductOptionCommandToProductOptionList(ProductOptionCommand poc);

  // ProductOption 리스트를 하나씩 db에 insert 하는 메소드
  void save(List<ProductOption> productOptions, Long productId);
}