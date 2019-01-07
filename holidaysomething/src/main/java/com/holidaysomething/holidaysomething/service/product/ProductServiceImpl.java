package com.holidaysomething.holidaysomething.service.product;

import com.holidaysomething.holidaysomething.domain.Product;
import com.holidaysomething.holidaysomething.domain.ProductImage;
import com.holidaysomething.holidaysomething.dto.SearchDto;
import com.holidaysomething.holidaysomething.repository.ProductRepository;
import java.time.LocalDateTime;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Slf4j
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

  private final ProductRepository productRepository;

  @Override
  @Transactional(readOnly = true)
  public Page<Product> findByProductNameContaining(String productName, Pageable pageable) {
    Page<Product> productByName = productRepository
        .findByProductNameContaining(productName, pageable);
    return productByName;
  }

  @Override
  @Transactional(readOnly = true)
  public List<Product> getAllProducts() {
    return productRepository.findAlByOrderByName();
  }

  @Override
  @Transactional(readOnly = true)
  public Product getProduct(Long id) {
    return productRepository.getOne(id);
  }

  @Override
  @Transactional(readOnly = true)
  public Page<Product> findAll(Pageable pageable) {
    return productRepository.findAll(pageable);
  }

  @Override
  @Transactional
  public ProductImage saveProductImage(ProductImage productImage) {
    return productRepository.save(productImage);
  }

  @Override
  @Transactional(readOnly = true)
  public Page<Product> findByProductRegdate(LocalDateTime regdateStart, LocalDateTime regdateEnd,
      Pageable pageable) {

    Page<Product> products = productRepository
        .findByProductRegdate(regdateStart, regdateEnd, pageable);

    return products;
  }

  @Override
  @Transactional(readOnly = true)
  public Page<Product> findProductAllOrSearch(SearchDto searchDto, Pageable pageable) {
    Page<Product> products = null;
    if (searchDto.isSearched()) { // 검색된 상품 리스트
      if (searchDto.getSearchType().equals("name")) {
        products = productRepository.findByProductNameContaining(searchDto.getKeyword(), pageable);
      } else if (searchDto.getSearchType().equals("code")) {
        products = productRepository.findByProductCodeContaining(searchDto.getKeyword(), pageable);
      }
    } else { // 모든 상품 리스트
      products = productRepository.findAll(pageable);
    }
    return products;
  }

  @Override
  @Transactional(readOnly = true)
  public Page<Product> findProducts(String searchClassificationValue,
      String searchClassificationInput, Long largeId, Long middleId, Long smallId,
      String dateValue, String startDateSelect, String endDateSelect, Pageable pageable) {

    return productRepository.findProducts(searchClassificationValue, searchClassificationInput,
        largeId, middleId, smallId, dateValue, startDateSelect, endDateSelect, pageable);
  }
}
