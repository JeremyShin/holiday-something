package com.holidaysomething.holidaysomething.repository;

import com.holidaysomething.holidaysomething.domain.ProductImage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface ProductImageRepository extends CrudRepository<ProductImage, Long> {
    // 상품 이미지 저장하기
    // INSERT INTO product_image (id, path, original_file_name, sotred_file_name, size, reg_date, update_date, product_id) VALUES ();
    ProductImage save(ProductImage productImage);
}
