package com.holidaysomething.holidaysomething.service.product;

import com.holidaysomething.holidaysomething.domain.Product;
import com.holidaysomething.holidaysomething.dto.ProductOrderDetailDto;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ProductService {

  ProductOrderDetailDto getProductForOrder(Long productId, Long optionId, Integer quantity);

  Page<Product> findAll(Pageable pageable);

  List<Product> getAllProducts();

  Product getProduct(Long id);

  Page<Product> findProducts(String productSearchClassificationValue,
      String productSearchClassificationInput, Long largeId, Long middleId, Long smallId,
      String productSearchDateValue, String productStartDateSelect, String productEndDateSelect,
      Pageable pageable);
}