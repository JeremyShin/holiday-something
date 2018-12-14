package com.holidaysomething.holidaysomething.controller.admin;

import com.holidaysomething.holidaysomething.domain.ProductImage;
import com.holidaysomething.holidaysomething.service.ProductImageServiceImpl;
import com.holidaysomething.holidaysomething.util.FileUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/admin/product")
public class AdminProductController {
    private ProductImageServiceImpl productImageService;
    private FileUtil fileUtil;

    public AdminProductController(ProductImageServiceImpl productImageService, FileUtil fileUtil){
        this.productImageService = productImageService;
        this.fileUtil = fileUtil;
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
    public String productDetail(){
        return "admin/product/product_detail";
    }


    // image upload
    @GetMapping("/product_image")
    public String productImage(){ return "admin/product/product_image"; }

    @PostMapping("/product_image")
    public String productImageAction(@RequestParam("file")MultipartFile file,
                                     HttpSession httpSession,
                                     HttpServletRequest httpServletRequest) {
        ProductImage productImage = fileUtil.handleFileStream(httpServletRequest, httpSession, file);
        return "redirect:/admin/product/product_detail";
    }
}
