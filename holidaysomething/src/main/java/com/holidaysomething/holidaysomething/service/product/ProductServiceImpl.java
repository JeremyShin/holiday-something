package com.holidaysomething.holidaysomething.service.product;

import com.holidaysomething.holidaysomething.domain.Product;
import com.holidaysomething.holidaysomething.domain.ProductImage;
import com.holidaysomething.holidaysomething.domain.ProductOption;
import com.holidaysomething.holidaysomething.dto.ProductOrderDetailDto;
import com.holidaysomething.holidaysomething.dto.SearchDto;
import com.holidaysomething.holidaysomething.repository.ProductImageRepository;
import com.holidaysomething.holidaysomething.repository.ProductOptionRepository;
import com.holidaysomething.holidaysomething.repository.ProductRepository;
import java.time.LocalDateTime;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Slf4j
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

  private final ProductRepository productRepository;
  private final ProductImageRepository productImageRepository;
  private final ProductOptionRepository productOptionRepository;

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
    return productRepository.findProductById(id);
  }

  @Override
  @Transactional(readOnly = true)
  public Page<Product> findAll(Pageable pageable) {
    return productRepository.findAll(pageable);
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

  @Override
  @Transactional(readOnly = true)
  public Product getProduct(Long categoryId, Long id) {
      return productRepository.findByProductCategoryIdAndId(categoryId, id);
  }

  @Override
  public ProductOrderDetailDto getProductForOrder(Long productId, Long optionId, Integer quantity) {
    ProductOrderDetailDto productOrderDetailDto = new ProductOrderDetailDto();

    Product product = productRepository.findProductById(productId);
    productOrderDetailDto.setProductId(product.getId());
    productOrderDetailDto.setProductName(product.getName());
    productOrderDetailDto.setManufacturer(product.getManufacturer());
    productOrderDetailDto.setMileage(product.getMileage());
    productOrderDetailDto.setOriginalPrice(product.getOriginalPrice());
    productOrderDetailDto.setSellingPrice(product.getSellingPrice());
    productOrderDetailDto.setShippingPrice(product.getShippingPrice());
    productOrderDetailDto.setQuantity(quantity);

    ProductOption productOption = productOptionRepository.findProductOptionById(optionId);
    productOrderDetailDto.setOptionId(productOption.getId());
    productOrderDetailDto.setOptionName(productOption.getName());
    productOrderDetailDto.setOptionPrice(productOption.getPrice());


      //productId로 이미지 url 검색하여 set
    List<ProductImage> productImages = productImageRepository.findByProductId(productId);
    if (productImages != null){
      productOrderDetailDto.setImg(productImages.get(0).getPath());
    }
      return productOrderDetailDto;
  }
}
