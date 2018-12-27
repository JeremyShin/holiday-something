package com.holidaysomething.holidaysomething.service;

import com.holidaysomething.holidaysomething.domain.Product;
import com.holidaysomething.holidaysomething.domain.ProductImage;
import com.holidaysomething.holidaysomething.dto.Search;
import com.holidaysomething.holidaysomething.repository.ProductCategoryRepository;
import com.holidaysomething.holidaysomething.repository.ProductRepository;

import java.time.LocalDateTime;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProductServiceImpl implements ProductService {

  private ProductRepository productRepository;
  private ProductCategoryRepository productCategoryRepository;

  public ProductServiceImpl(ProductRepository productRepository,
      ProductCategoryRepository productCategoryRepository) {
    this.productRepository = productRepository;
    this.productCategoryRepository = productCategoryRepository;
  }

  @Transactional(readOnly = true)
  @Override
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

  @Transactional
  @Override
  public ProductImage saveProductImage(ProductImage productImage) {
    return productRepository.save(productImage);
  }

  @Transactional(readOnly = true)
  @Override
  public Page<Product> findByProductRegdate(LocalDateTime regdateStart, LocalDateTime regdateEnd,
      Pageable pageable) {

    Page<Product> products = productRepository
        .findByProductRegdate(regdateStart, regdateEnd, pageable);

    return products;
  }

  @Transactional(readOnly = true)
  @Override
  public Page<Product> findProductAllOrSearch(Search search, Pageable pageable) {
    Page<Product> products = null;
    if (search.isSearched()) { // 검색된 상품 리스트
      if (search.getSearchType().equals("name")) {
        products = productRepository.findByProductNameContaining(search.getKeyword(), pageable);
      } else if (search.getSearchType().equals("code")) {
        products = productRepository.findByProductCodeContaining(search.getKeyword(), pageable);
      }
    } else { // 모든 상품 리스트
      products = productRepository.findAll(pageable);
    }
    return products;
  }
}
