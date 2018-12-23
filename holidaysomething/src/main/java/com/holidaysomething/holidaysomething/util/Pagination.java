package com.holidaysomething.holidaysomething.util;

public class Pagination {
    private int totalProductCount;  // 총 상품 수
    private int totalPageCount;     // 총 페이지 수
    private int productCount;       // 한 화면에 보여질 상품의 수
    private int pageSize;           // 한 화면에 보여질 페이지 수
    private int startPage;          // 현재 화면에서 보이는 시작 페이지 번호  ex) [1][2][3][4][5] --> startPage=1
    private int endPage;            // 현재 화면에서 보이는 마지막 페이지 번호                    --> endPage=5

}
