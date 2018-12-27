package com.holidaysomething.holidaysomething.service.admin;

import com.holidaysomething.holidaysomething.domain.Product;
import com.holidaysomething.holidaysomething.domain.ProductCategory;
import com.holidaysomething.holidaysomething.domain.ProductDetail;
import com.holidaysomething.holidaysomething.dto.ProductDto;
import com.holidaysomething.holidaysomething.repository.ProductCategoryRepository;
import com.holidaysomething.holidaysomething.repository.ProductDetailRepository;
import com.holidaysomething.holidaysomething.repository.ProductRepository;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AdminProductRegisterServiceImpl implements AdminProductRegisterService {

  private ProductCategoryRepository productCategoryRepository;
  private ProductDetailRepository productDetailRepository;
  private ProductRepository productRepository;
  private static final Log log = LogFactory.getLog(AdminProductRegisterServiceImpl.class);

  public AdminProductRegisterServiceImpl(ProductCategoryRepository productCategoryRepository,
      ProductDetailRepository productDetailRepository, ProductRepository productRepository) {
    this.productCategoryRepository = productCategoryRepository;
    this.productDetailRepository = productDetailRepository;
    this.productRepository = productRepository;
  }

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

  @Override
  @Transactional
  public Product productDtoToProduct(ProductDto productDto) {

    Product product = new Product();

    product.setName(productDto.getName());
    product.setOriginalPrice(productDto.getOriginalPrice());
    product.setSellingPrice(productDto.getSellingPrice());
    product.setManufacturingPrice(productDto.getManufacturingPrice());
    product.setCode(productDto.getCode());
    product.setManufacturer(productDto.getManufacturer());
    product.setShippingPrice(productDto.getShippingPrice());
    product.setProductDetail(new ProductDetail(productDto.getProductDescription()));

    product.setMileage(productDto.getMileage());
    product.setQuantity(productDto.getQuantity());
    product.setSafeQuantity(productDto.getSafeQuantity());
    product.setManufactureDate(productDto.getManufactureDate());
    product.setReleaseDate(productDto.getReleaseDate());
    product.setRegDate(productDto.getRegDate());

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
  public Product productRegister(Product product) {

    // 상품 등록하기 전에 상품내용먼저 등록한 후에 그 데이터를 상품에 set 해준다.
    ProductDetail productDetail =
        productDetailRepository
            .save(new ProductDetail(product.getProductDetail().getDescription()));

    // id를 이용해서 상품에 넣어야 하는 카테고리 인스턴스를 생성해야해!
    // 왜? 카테고리가 fk 를 가지고 있어!. 근데 이 fk 를 등록하려면 카테고리 인스턴스가 필요해!
    ProductCategory productCategory = productCategoryRepository.findByIdContaining(
        product.getProductCategory().getId());

    // 상품에 set 해줘버리기~
    product.setProductDetail(productDetail);
    product.setProductCategory(productCategory);

    productRepository.save(product);

    return product;
  }
}
