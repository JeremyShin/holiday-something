package com.holidaysomething.holidaysomething.controller.admin;

import com.holidaysomething.holidaysomething.domain.ProductOption;
import com.holidaysomething.holidaysomething.domain.Product;
import com.holidaysomething.holidaysomething.service.ProductService;
import com.holidaysomething.holidaysomething.service.ProductOptionService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.ui.Model;

@Controller
@RequestMapping("/admin/product")
public class AdminProductController {
    private ProductOptionService productOptionService;
    private ProductService productService;

    private static final Log log = LogFactory.getLog(AdminProductController.class);

    public AdminProductController(ProductOptionService productOptionService, ProductService productService) {
        this.productOptionService = productOptionService;
        this.productService = productService;
    }

    @GetMapping
    public String product() {
        return "admin/product/product";
    }

    @GetMapping("/product_category")
    public String productCategory() {
        return "admin/product/product_category";
    }

    @GetMapping({"/product_detail", "/product_detail/{pageStart}"})
    public String productDetail(ModelMap modelMap, @PathVariable Optional<Integer> pageStart) {
        List<ProductOption> productOptionList = productOptionService.getAllProductOptions();
        int productOptionListSize = productOptionList.size();
        modelMap.addAttribute("productOptionList", productOptionList);
        modelMap.addAttribute("productOptionListSize", productOptionListSize);

        Pageable pageable = PageRequest.of(pageStart.isPresent() ? pageStart.get()-1 : 0, 10);
        Page<ProductOption> productOptions = productOptionService.getAllProductOptionsPage(pageable);

        int pageCount = productOptions.getTotalPages();
        log.info("pageCount: " + pageCount);
        modelMap.addAttribute("pageCount", pageCount);
        modelMap.addAttribute("productOptions", productOptions);

        return "admin/product/product_detail";
    }

    @PostMapping("/product_detail/bundle")
    public String productDetailBundle(ModelMap modelMap,
                                      @RequestParam("productOptionBundleSize") int size) {
        List<ProductOption> productOptionList = productOptionService.getAllProductOptions();
        int productOptionListSize = productOptionList.size();
        modelMap.addAttribute("productOptionList", productOptionList);
        modelMap.addAttribute("productOptionListSize", productOptionListSize);

        Pageable pageable = PageRequest.of(0, size);
        Page<ProductOption> productOptions = productOptionService.getAllProductOptionsPage(pageable);

        int pageCount = productOptions.getTotalPages();
        log.info("pageCount: " + pageCount);
        modelMap.addAttribute("pageCount", pageCount);
        modelMap.addAttribute("productOptions", productOptions);

        return "admin/product/product_detail";
    }

    @PostMapping("/delete/product_option")
    public String deleteProductOption(@RequestParam("productOptionId") String[] productOptionIds) {

        // check된 row를 `productOption` 테이블에서 삭제
        for (String id : productOptionIds) {
            productOptionService.deleteProductOption(Long.parseLong(id));
            log.info(id + "번 productOption 삭제 완료");
        }

        // 옵션 삭제 후 현재 페이지로 redirect
        return "redirect:/admin/product/product_detail";
    }

    @GetMapping("/get/name")
    public String getProductOptionsByName(
            ModelMap modelMap,
            @RequestParam("productOptionSearchField") String productOptionSearchField,
            @RequestParam("productOptionSearchValue") String productOptionSearchValue) {
        log.info("productOptionSearchField: " + productOptionSearchField);
        log.info("productOptionSearchValue: " + productOptionSearchValue);

        // `product_option`에서 productOptionSearchField가 productOptionSearchValue인 row를 검색
        // 검색된 결과를 페이징 처리하여 보여준다
        Page<ProductOption> productOptions = new PageImpl<>(new ArrayList<>());
        Pageable pageable = PageRequest.of(0, 10);

        if (productOptionSearchField.equals("name")) {
            productOptions = productOptionService.getAllProductOptionsByNamePage(productOptionSearchValue, pageable);
        } else if (productOptionSearchField.equals("description")) {
            productOptions = productOptionService.getAllProductOptionsByDescriptionPage(productOptionSearchValue, pageable);
        } else if (productOptionSearchField.equals("price")) {
            productOptions = productOptionService.getAllProductOptionsByPricePage(productOptionSearchValue, pageable);
        }
        int pageCount = productOptions.getTotalPages();
        log.info("pageCount: " + pageCount);
        modelMap.addAttribute("pageCount", pageCount);
        modelMap.addAttribute("productOptionsSearchResult", productOptions);

        return "/admin/product/product_detail";
    }

    /* 옵션 등록 */
    @GetMapping("/product_detail_add_option")
    public String addOption(Model model) {
        // 모든 상품목록 가져오기
        List<Product> products = productService.getAllProducts();
        model.addAttribute("products", products);

        return "admin/product/product_detail_add_option";
    }

    /* 옵션 등록 */
    @PostMapping("/product_detail_add_option")
    public String addProductOption(ProductOption productOption,
                                   @RequestParam(value = "productId", defaultValue = "") Long productId) {

            productOption.setProduct(productService.getProduct(productId));
            productOptionService.addProductOption(productOption);
//
//        for(ProductOption productOption : productOptions){
//            productOption.setProduct(productService.getProduct(productId));
//            productOptionService.addProductOption(productOption);
//        }

        return "admin/product/product_detail_add_option";
    }
}
