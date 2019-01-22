package com.holidaysomething.holidaysomething.service.product;

import com.holidaysomething.holidaysomething.domain.Product;
import com.holidaysomething.holidaysomething.domain.ProductCategory;
import com.holidaysomething.holidaysomething.domain.ProductDetail;
import com.holidaysomething.holidaysomething.dto.ProductAddDto;
import com.holidaysomething.holidaysomething.dto.ProductDto;
import com.holidaysomething.holidaysomething.repository.ProductCategoryRepository;
import com.holidaysomething.holidaysomething.repository.ProductDetailRepository;
import com.holidaysomething.holidaysomething.repository.ProductRepository;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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
public class ProductAddServiceImpl implements ProductAddService {

  private final ProductCategoryRepository productCategoryRepository;
  private final ProductDetailRepository productDetailRepository;
  private final ProductRepository productRepository;

  @Override
  public Page<Product> getAllProducts(Pageable pageable) {
    return productRepository.findAll(pageable);
  }

  @Override
  @Transactional
  public List<ProductCategory> productCategoryList(Long parentId) {
    List<ProductCategory> categories = productCategoryRepository.findCategory(parentId);
    log.info("========================================================");
    log.info("categoryId (" + parentId + ")의 자식 카테고리 " + categories.size() + "개 불러옴");
    for (int i = 0; i < categories.size(); i++) {
      log.info(i + 1 + ". " + categories.get(i).getName());
    }
    return categories;
  }


  /**
   * @author JDragon DTO 객체를 Product(도메인) 객체로 바꿔주는 메소드.
   */
  @Override
  @Transactional
  public Product productDtoToProduct(ProductAddDto productDto) {

    Product product = new Product();

    product.setName(productDto.getName());
    product.setOriginalPrice(productDto.getOriginalPrice());
    product.setSellingPrice(productDto.getSellingPrice());
    product.setManufacturingPrice(productDto.getManufacturingPrice());
    product.setCode(productDto.getCode());
    product.setManufacturer(productDto.getManufacturer());
    product.setShippingPrice(productDto.getShippingPrice());
    product.setQuantity(productDto.getQuantity());
    product.setSellingQuantity(productDto.getSellingQuantity());
    product.setSafeQuantity(productDto.getSafeQuantity());
    product.setMileage(productDto.getMileage());
    product.setOptionalPriceText(productDto.getOptionalPriceText());
    product.setRegDate(LocalDateTime.now());

    String manufactureDateStr = productDto.getManufactureDate() + ":00";
    String releaseDateStr = productDto.getReleaseDate() + ":00";

    log.info("=== manufactureDateStr : " + manufactureDateStr);
    log.info("=== releaseDateStr : " + releaseDateStr);

    LocalDateTime manufactureDate = LocalDateTime
        .parse(manufactureDateStr, DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss"));
    LocalDateTime releaseDate = LocalDateTime
        .parse(releaseDateStr, DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss"));

    product.setManufactureDate(manufactureDate);
    product.setReleaseDate(releaseDate);

    // null 이면
    if (productDto.getDisplay() == null) {
      product.setDisplay(false);
    } else {
      product.setDisplay(productDto.getDisplay());
    }

    return product;
  }


  @Override
  @Transactional
  public Product productRegister(ProductAddDto productAddDto) {

    // 상품 등록하기 전에 상품내용먼저 등록한 후에 그 데이터를 상품에 set 해준다.
    ProductDetail productDetail =
        productDetailRepository
            .save(new ProductDetail(productAddDto.getProductDetail()));

    // id를 이용해서 상품에 넣어야 하는 카테고리 인스턴스를 생성해야해!
    // 왜? 카테고리가 fk 를 가지고 있어!. 근데 이 fk 를 등록하려면 카테고리 인스턴스가 필요해!
    ProductCategory productCategory = productCategoryRepository.findByIdContaining(
        productAddDto.getProductCategoryId());

    // 상품 등록하기 위해 Dto 객체를 Product(Domain) 객체로 바꿔주기~
    Product product = productDtoToProduct(productAddDto);

    // 상품에 set 해줘버리기~
    product.setProductDetail(productDetail);
    product.setProductCategory(productCategory);

    productRepository.save(product);

    return product;


  }
}