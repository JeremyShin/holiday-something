package com.holidaysomething.holidaysomething.service.product;

import com.holidaysomething.holidaysomething.domain.ProductDetail;
import com.holidaysomething.holidaysomething.repository.ProductDetailRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;


@Service
@Slf4j
@RequiredArgsConstructor
public class ProductDetailServiceImpl implements ProductDetailService {

    private final ProductDetailRepository productDetailRepository;

    @Override
    public ProductDetail save(String productDetail) {
        ProductDetail productDetail1 = new ProductDetail();
        productDetail1.setDescription(productDetail);
        return productDetailRepository.save(productDetail1);
    }
}
