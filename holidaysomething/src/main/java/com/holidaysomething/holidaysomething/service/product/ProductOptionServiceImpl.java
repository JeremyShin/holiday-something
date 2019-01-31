package com.holidaysomething.holidaysomething.service.product;

import com.holidaysomething.holidaysomething.domain.Product;
import com.holidaysomething.holidaysomething.domain.ProductOption;
import com.holidaysomething.holidaysomething.dto.ProductOptionCommand;
import com.holidaysomething.holidaysomething.dto.ProductOrderDetailDto;
import com.holidaysomething.holidaysomething.repository.ProductOptionRepository;
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
public class ProductOptionServiceImpl implements ProductOptionService {

  private final ProductOptionRepository productOptionRepository;

  @Override
  @Transactional(readOnly = true)
  public List<ProductOption> getAllProductOptions() {
    return productOptionRepository.findAll();
  }

  @Override
  @Transactional(readOnly = true)
  public ProductOption getProductOption(Long id) {
    return productOptionRepository.getOne(id);
  }

  @Override
  public void deleteProductOption(Long id) {
    productOptionRepository.deleteById(id);
  }

  @Override
  @Transactional
  public void save(ProductOption productOption) {
    productOptionRepository.save(productOption);
  }

  @Override
  @Transactional(readOnly = true)
  public Page<ProductOption> getAllProductOptionsByNamePage(String name, Pageable pageable) {
    return productOptionRepository.findAllProductOptionByNameContaining(name, pageable);
  }

  @Override
  public Page<ProductOption> getAllProductOptionsByDescriptionPage(String description,
      Pageable pageable) {
    return productOptionRepository
        .findAllProductOptionByDescriptionContaining(description, pageable);
  }

  @Override
  public Page<ProductOption> getAllProductOptionsByPricePage(String price, Pageable pageable) {
    return productOptionRepository.findAllProductOptionByPriceContaining(price, pageable);
  }

  @Override
  @Transactional(readOnly = true)
  public Page<ProductOption> getAllProductOptionsPage(Pageable pageable) {
    return productOptionRepository.findAll(pageable);
  }

  @Override
  @Transactional
  public Page<ProductOption> getProductOptionsByProductId(Long productId, Pageable pageable) {
    return productOptionRepository.findByProductId(productId, pageable);
  }

  @Override
  @Transactional
  public List<ProductOption> fromProductOptionCommandToProductOptionList(ProductOptionCommand poc) {
    List<ProductOption> productOptions = poc.getProductOptions();
    return productOptions;
  }

  @Override
  @Transactional
  public void save(List<ProductOption> productOptions, Long productId) {
    Product product = new Product();
    product.setId(productId);

    for (ProductOption productOption : productOptions) {
      productOption.setProduct(product);
      productOptionRepository.save(productOption);
    }
  }

  @Override
  public List<ProductOption> getProductOptionsByProductId(Long productId) {
    return productOptionRepository.findByProductId(productId);
  }

  @Override
  public ProductOrderDetailDto getProductOptionForOrder(ProductOrderDetailDto productOrderDetailDto, ProductOption productOption) {
    log.info("주문 서비스 입니다.");
    log.info("넘어온 옵션의 아이디는 " + productOption.getId());
    log.info("검색한 옵션의 아이디는" + productOption.getId());

    productOrderDetailDto.getOptionName().add(productOption.getName());
    productOrderDetailDto.getOptionPrice().add(productOption.getPrice());

    return  productOrderDetailDto;
  }
}