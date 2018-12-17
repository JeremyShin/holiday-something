package com.holidaysomething.holidaysomething.repository;

import com.holidaysomething.holidaysomething.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


public interface ProductRepository extends JpaRepository<Product, Long> {

    // 상품등록
    public Product save(Product product);

    @Query("select count(p) from Product p")
    public int countAll();

    // 상품 등록 (fk 카테고리 추가)
    // public Product save(Product product,Long categoryId);


}




/*

4. 상품 등록
        1. 상품분류선택하기
        2. ~~메인 진열~~~~(협의)~~
        3. 등록 기본 정보
           1. 상품명
           2. 제조사
           3. 상품코드
           4. 원가(original_price)
           5. 판매가(selling_price)
           6. 제조가(manufacturing_price)
           7. 배송비
           8. 상품 설명
           9. 상품 옵션(선택/등록)
        4. 판매 정보
           1. 대체 문구
           2. 적립금(개별설정/기본설정)
        5. 재고 설정
           1. 재고 수량 / 안전 재고(재고가 특정 수 이하가 되면 알림을)
        6. 상품 이미지 등록
           1. 개별 이미지 등록(상세/목록/작은목록/축소/확대이미지)
           2. 추가 이미지 등록
           3. 상품 상세 설명 이미지 등록
        7. ~~상세 이용 안내(협의)~~
        8. 검색엔진 최적화(SEO)
           파라미터 : 검색 엔진 노출 설정, title, Author, Description, Keywords, 상품 이미지 Alt 텍스트
        9. <u>추천/관련 상품 (2단계!!)</u>




 */