package com.holidaysomething.holidaysomething.controller.admin;

import com.holidaysomething.holidaysomething.domain.Product;
import com.holidaysomething.holidaysomething.domain.ProductImage;
import com.holidaysomething.holidaysomething.dto.UploadFileInfo;
import com.holidaysomething.holidaysomething.service.ProductService;
import com.holidaysomething.holidaysomething.util.FileUtil;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/admin/product")
public class AdminProductController {
    private ProductService productService;
    private FileUtil fileUtil;

    public AdminProductController (ProductService productService, FileUtil fileUtil){
        this.productService = productService;
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

    @GetMapping("/product_list")
    public String productList(ModelMap modelMap, @PageableDefault(sort = { "id" }, direction = Sort.Direction.DESC , size = 10)Pageable pageable){
        Page<Product> products = productService.findAll(pageable);
        modelMap.addAttribute("products", products);
        return "admin/product/product_list";
    }

    @GetMapping("/product_image")
    public String productImage(){
        return "admin/product/product_image";
    }

    @PostMapping("/product_image")
    public String productImageUpload(@RequestParam("file")MultipartFile file,
                                     ModelMap modelMpa,
                                     HttpSession session,
                                     HttpServletRequest request){
        ProductImage productImage = fileUtil.handleFileStream(request, session, file);
        productService.saveProductImage(productImage);
        return "redirect:/admin/product/product_list";
    }
}
