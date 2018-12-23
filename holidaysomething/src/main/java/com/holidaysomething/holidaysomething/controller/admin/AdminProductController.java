package com.holidaysomething.holidaysomething.controller.admin;

import com.holidaysomething.holidaysomething.domain.Product;
import com.holidaysomething.holidaysomething.domain.ProductCategory;
import com.holidaysomething.holidaysomething.domain.ProductImage;
import com.holidaysomething.holidaysomething.domain.ProductOption;
import com.holidaysomething.holidaysomething.dto.ProductDto;
import com.holidaysomething.holidaysomething.dto.ProductSearch;
import com.holidaysomething.holidaysomething.service.ProductOptionService;
import com.holidaysomething.holidaysomething.service.ProductService;
import com.holidaysomething.holidaysomething.service.admin.AdminProductService;
import com.holidaysomething.holidaysomething.util.FileUtil;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/admin/product")
public class AdminProductController {

  private static final Log log = LogFactory.getLog(AdminProductController.class);
  private ProductService productService;
  private ProductOptionService productOptionService;

  private AdminProductService adminProductService;
  private FileUtil fileUtil;

  public AdminProductController(ProductOptionService productOptionService,
      ProductService productService, AdminProductService adminProductService, FileUtil fileUtil) {
    this.productOptionService = productOptionService;
    this.productService = productService;
    this.adminProductService = adminProductService;
    this.fileUtil = fileUtil;
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

    Pageable pageable = PageRequest.of(pageStart.isPresent() ? pageStart.get() - 1 : 0, 10);
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

  // 대분류 불러오기.
  @GetMapping("/product_detail/register")
  public String productRegister(ModelMap model) {
    List<ProductCategory> categories = adminProductService.productCategoryList(0l);

//    Product product = new Product();
//    ProductDetail productDetail = new ProductDetail();
//    ProductCategory productCategory = new ProductCategory();
    ProductDto productDto = new ProductDto();

    model.addAttribute("categories", categories);
//        model.addAttribute("product",product);
//        model.addAttribute("productDetail",productDetail);
//        model.addAttribute("productCategory",productCategory);
    model.addAttribute("productDto", productDto);

    //model.put("categories", categories);
    return "admin/product/product_register";
  }

  // 중소분류 읽어오기.
  @ResponseBody
  @GetMapping("/product_detail/register/lowcategories/{parentId}")
  public List<ProductCategory> getLowLevelCategories(@PathVariable("parentId") Long parentId) {
    List<ProductCategory> categories = adminProductService.productCategoryList(parentId);
    System.out.println("===================  " + categories.size());
    return categories;
  }

  // 상품등록 , date1 : 제조일  ,  date2 : 출시일.
  @PostMapping("/product_detail/register")
  public String registerProduct(@ModelAttribute(value = "productDto") ProductDto productDto,
      @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime date1,
      @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime date2,
      BindingResult bindingResult) {

    /*
     * if(bindingResult.hasErrors) {
     *   return "/admin/product/product_detail/register";
     * }else{
     *   등록작업
     *   return "rediret";
     * }
     */
    // productDto 로 날짜들을 가져올때... 타입이 맞지 않는다고 오류가 난다
    // 뷰에서 input으로 데이터를 보낼때 String으로 보내고. 컨트롤러에선 LocalDateTime으로 받아야하니
    // 문제가 생기는거같다. 그래서 일단은 날짜 받는부분은 따로 처리했다.

    String description = productDto.getProductDescription();

    Long parentId = productDto.getProductCategoryId();

    System.out.println("상품명 : " + productDto.getName());
    System.out.println("체크박스 :  " + productDto.getDisplay());

    productDto.setManufactureDate(date1);
    productDto.setReleaseDate(date2);
    productDto.setRegDate(LocalDateTime.now());

    System.out.println("등록일 : " + productDto.getRegDate());

//    date2 = date2.replace("T"," ");
//    System.out.println("RequestParam , String : " + date2);
//    LocalDateTime ldt = LocalDateTime.parse(date2, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
//    System.out.println("RequestParam , String : " + ldt.toString());

    Product product = adminProductService.productDtoToProduct(productDto);

    product = adminProductService.productRegister(product, description, parentId);

    return "redirect:/admin/product/product_detail/register";


  }

  @GetMapping("/product_list")
  public String productList(@PageableDefault(sort = {"id"}, direction = Sort.Direction.DESC, size = 10) Pageable pageable,
                            @ModelAttribute("search")ProductSearch productSearch, ModelMap modelMap) {
    // 커맨드 객체와 @ModelAttribute 같다. 다만 @ModelAttribute 뷰에서 사용할 모델의 이름을 변경할 때 사용

    Page<Product> products = productService.findProductAllOrSearch(productSearch, pageable);

    modelMap.addAttribute("products", products);

    return "admin/product/product_list";
  }

  @GetMapping("/product_image")
  public String productImage() {
    return "admin/product/product_image";
  }


  @PostMapping("/product_image")
  public String productImageUpload(@RequestParam("file") MultipartFile file,
      ModelMap modelMpa,
      HttpSession session,
      HttpServletRequest request) {
    ProductImage productImage = fileUtil.handleFileStream(request, session, file);
    productService.saveProductImage(productImage);
    return "redirect:/admin/product/product_list";
  }

  // 오류난다~~~~~!
//    @GetMapping("/product_detail")
//    public String productDetail(ModelMap modelMap) {
//        List<ProductOption> productOptionList = productOptionService.getAllProductOptions();
//        modelMap.addAttribute("productOptionList", productOptionList);
//        modelMap.addAttribute("productOptionListSize", productOptionList.size());
//
//        return "admin/product/product_detail";
//    }

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
      productOptions = productOptionService
          .getAllProductOptionsByNamePage(productOptionSearchValue, pageable);
    } else if (productOptionSearchField.equals("description")) {
      productOptions = productOptionService
          .getAllProductOptionsByDescriptionPage(productOptionSearchValue, pageable);
    } else if (productOptionSearchField.equals("price")) {
      productOptions = productOptionService
          .getAllProductOptionsByPricePage(productOptionSearchValue, pageable);
    }
    int pageCount = productOptions.getTotalPages();
    log.info("pageCount: " + pageCount);
    modelMap.addAttribute("pageCount", pageCount);
    modelMap.addAttribute("productOptionsSearchResult", productOptions);

    return "/admin/product/product_detail";
  }

    @GetMapping("/product_search")
    public String productSearch(ModelMap modelMap) {

//        List<ProductCategory> productBigCategories =  productService.findByProductBigCategoryContaining();
//        modelMap.addAttribute("bigCategory", productBigCategories);
//        if(bigId == null) {
//
//        }else {
//            List<ProductCategory> productMiddleCategories = productService.findByProductMiddleCategoryContaining(bigId);
//            modelMap.addAttribute("middleCategory", productMiddleCategories);
//        }

        return "admin/product/product_search";
    }

  @PostMapping("/product_search/result")
  public String searchResult(ModelMap modelMap,
      @RequestParam(value = "productName") String product,
      @RequestParam(value = "page", defaultValue = "1") int start) {

    Pageable pageable = PageRequest.of(start, start + 5);

    // 제품명으로 검색하기
    Page<Product> products = productService.findByProductNameContaining(product, pageable);
    modelMap.addAttribute("products", products);
    modelMap.addAttribute("totalPages", products.getTotalPages());
    modelMap.addAttribute("presentPage", products.getNumber());

    return "admin/product/product_search_result";
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

    return "admin/product/product_detail_add_option";
  }
}
