package com.holidaysomething.holidaysomething.controller.admin.product;

import com.holidaysomething.holidaysomething.domain.Product;
import com.holidaysomething.holidaysomething.domain.ProductCategory;
import com.holidaysomething.holidaysomething.domain.ProductImage;
import com.holidaysomething.holidaysomething.domain.ProductOption;
import com.holidaysomething.holidaysomething.dto.ProductAddDto;
import com.holidaysomething.holidaysomething.service.fileupload.ImageStreamService;
import com.holidaysomething.holidaysomething.service.product.ProductAddService;
import com.holidaysomething.holidaysomething.service.product.ProductImageService;
import com.holidaysomething.holidaysomething.service.product.ProductOptionService;
import com.holidaysomething.holidaysomething.service.product.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/admin/product")
@Slf4j
@RequiredArgsConstructor
public class AdminProductController {

    private final ProductService productService;
    private final ProductOptionService productOptionService;
    private final ProductAddService productAddService;
    private final ProductImageService productImageService;
    private final ImageStreamService imageStreamService;

    @GetMapping
    public String product() {
        return "admin/product/index";
    }

    @GetMapping("/category")
    public String productCategory() {
        return "admin/product/category";
    }


    /**
     * @author JDragon 상품등록하기 페이지.
     */
    @GetMapping("/add")
    public String productAdd(ModelMap model) {
        //List<ProductCategory> categories = productAddService.productCategoryList(0l);
        //model.addAttribute("categories", categories);
        Product product = new Product();
        model.addAttribute("product", product);
        return "admin/product/add";
    }


    /**
     * @param bindingResult (반드시 @Valid 객체 뒤에 위치해야 한다.)
     *                      The BindingResult must come right after the model object that is validated or
     *                      else Spring will fail to validate the object and throw an exception.
     * @author JDragon
     */
    @PostMapping("/add")
    public String productAddPost(
            @Valid @ModelAttribute(value = "product") ProductAddDto productAddDto,
            BindingResult bindingResult,
            MultipartFile mainImage, MultipartFile[] subImages) {

        if (bindingResult.hasErrors()) {
            for (ObjectError error : bindingResult.getAllErrors()) {
                log.info(error.getDefaultMessage());
                //model.addAttribute("product", product);
            }
            return "admin/product/add";
        } else {
            //등록작업
            productAddDto.setRegDate(LocalDateTime.now());
            productAddService.productRegister(productAddDto);

            imageStreamService.save(mainImage, productAddDto.getProductDetailId());
            for(MultipartFile multipartFile : subImages) {
                imageStreamService.save(multipartFile, productAddDto.getProductDetailId());
            }

            return "redirect:/admin/product/add";
        }

        // productDto 로 날짜들을 가져올때... 타입이 맞지 않는다고 오류가 난다
        // 뷰에서 input으로 데이터를 보낼때 String으로 보내고. 컨트롤러에선 LocalDateTime으로 받아야하니
        // 문제가 생기는거같다. 그래서 일단은 날짜 받는부분은 따로 처리했다.
        // 아니다. 계속 null 값만 받아와서. 그렇다.

    }


     // Tui editor 사용 시 이미지 미리보기 기능
    @GetMapping("/image-files/{fileName}")
    @ResponseBody
    public void handleFileUpload(@PathVariable("fileName") String fileName,
                                 HttpServletResponse response) {

        ProductImage productImage = productImageService.getProductImage(fileName);

        response.setContentLengthLong(productImage.getSize());
        response.setContentType(productImage.getFileType());

        try {
            imageStreamService.readAndWrite(productImage.getPath() + productImage.getStoredFileName(), response.getOutputStream());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @GetMapping("/search")
    public String productSearch(ModelMap modelMap,
                                @RequestParam(value = "page", defaultValue = "1") int page) {

        // 대분류를 불러온다
        List<ProductCategory> largeCategories = productAddService.productCategoryList(0L);
        modelMap.addAttribute("largeCategories", largeCategories);

        // 모든 상품 리스트를 불러온다(페이지)
        Pageable pageable = PageRequest.of(page - 1, 10);
        log.info("page는" + page);
        log.info("pageable" + pageable.toString());
        Page<Product> allProductList = productAddService.getAllProducts(pageable);
        int productPageCount = allProductList.getTotalPages();

        modelMap.addAttribute("allProductList", allProductList);
        modelMap.addAttribute("productPageCount", productPageCount);

        return "admin/product/search";
    }

    @PostMapping("/search")
    public String productSearchPost(ModelMap modelMap,
                                    @RequestParam(value = "productSearchClassification", required = false) String searchClassificationValue,
                                    @RequestParam(value = "productSearchClassificationInput", required = false) String searchClassificationInput,
                                    @RequestParam(value = "productLargeCategoryId", required = false) Long largeId,
                                    @RequestParam(value = "productMiddleCategoryId", required = false) Long middleId,
                                    @RequestParam(value = "productSmallCategoryId", required = false) Long smallId,
                                    @RequestParam(value = "productDate", required = false) String dateValue,
                                    @RequestParam(value = "productRegDateStart", required = false) @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm") String startDateSelect,
                                    @RequestParam(value = "productRegDateEnd", required = false) @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm") String endDateSelect) {

        log.info("searchClassificationValue: " + searchClassificationValue);
        log.info("searchClassificationInput: " + searchClassificationInput);
        log.info("largeId: " + largeId);
        log.info("middleId: " + middleId);
        log.info("smallId: " + smallId);
        log.info("dateValue: " + dateValue);
        log.info("startDateSelect: " + startDateSelect);
        log.info("endDateSelect: " + endDateSelect);

        // 모든 상품 리스트를 불러온다(페이지)
        // TODO: 검색 결과도 페이징 처리 필요
        Pageable pageable = PageRequest.of(0, 10);

        // QueryDSL 적용
        Page<Product> productPage = productService
                .findProducts(searchClassificationValue, searchClassificationInput,
                        largeId, middleId, smallId, dateValue, startDateSelect, endDateSelect, pageable);
        int productPageCount = productPage.getTotalPages();

        modelMap.addAttribute("allProductList", productPage);
        modelMap.addAttribute("productPageCount", productPageCount);

        return "admin/product/search";
    }


    //

    /**
     * @author JDragon 기간검색시 앞 시각이 뒷 시각보다 미래면 안되는 것과 같은. 검색 조건 validation 이 필요하다.
     */
    @GetMapping("/{productId}")
    public String productDetail(@PathVariable("productId") Long productId,
                                @RequestParam(required = false, value = "optionPage") Optional<Integer> pageNum,
                                ModelMap model) {

        // 상품id 로 상품 정보 가져오기.
        Product product = productService.getProduct(productId);
        model.addAttribute("product", product);

        // html 파일에서 페이징 처리 한 부분은 1로 시작하고
        // Pageable 에서 페이지는 0 부터 시작하므로 1을 빼줘야한다.
        Pageable pageable;

        if (pageNum.isPresent()) {
            if (pageNum.get().equals(0)) {
                // 주소창에 admin/product/1?optionPage=0 을 입력했을시
                // 정상 처리하는 로직
                pageable = PageRequest.of(0, 5);
            } else {
                pageable = PageRequest.of(pageNum.isPresent() ? pageNum.get() - 1 : 0, 5);
            }
        } else {
            pageable = PageRequest.of(0, 5);
        }

        //Page<ProductOption> productOptions =
        Page<ProductOption> productOptions = productOptionService
                .getProductOptionsByProductId(productId, pageable);

        model.addAttribute("productOptions", productOptions);

        int pageCount = productOptions.getTotalPages();
        model.addAttribute("pageCount", pageCount);
        model.addAttribute("productId", productId);

        return "admin/product/detail";
    }

}
