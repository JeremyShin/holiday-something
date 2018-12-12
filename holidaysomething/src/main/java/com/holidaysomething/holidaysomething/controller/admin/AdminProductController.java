package com.holidaysomething.holidaysomething.controller.admin;

import com.holidaysomething.holidaysomething.domain.ProductOption;
import com.holidaysomething.holidaysomething.service.ProductOptionService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/admin/product")
public class AdminProductController {
    private ProductOptionService productOptionService;
    private static final Log log = LogFactory.getLog(AdminProductController.class);

    public AdminProductController(ProductOptionService productOptionService) {
        this.productOptionService = productOptionService;
    }

    @GetMapping
    public String product(){
        return "admin/product/product";
    }

    @GetMapping("/product_category")
    public String productCategory(){
        return "admin/product/product_category";
    }

    @GetMapping("/product_detail")
    public String productDetail(ModelMap modelMap) {
        List<ProductOption> productOptionList = productOptionService.getAllProductOptions();
        modelMap.addAttribute("productOptionList", productOptionList);
        modelMap.addAttribute("productOptionListSize", productOptionList.size());

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
}
