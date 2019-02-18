package com.holidaysomething.holidaysomething.controller.user.order;

import com.holidaysomething.holidaysomething.domain.Order;
import com.holidaysomething.holidaysomething.domain.OrderedProduct;
import com.holidaysomething.holidaysomething.domain.Product;
import com.holidaysomething.holidaysomething.domain.ProductOption;
import com.holidaysomething.holidaysomething.domain.Shipping;
import com.holidaysomething.holidaysomething.dto.AddOrderMemberDto;
import com.holidaysomething.holidaysomething.dto.ProductOrderCompleteDto;
import com.holidaysomething.holidaysomething.dto.ProductOrderDetailDto;
import com.holidaysomething.holidaysomething.dto.ProductOrderInfoCommand;
import com.holidaysomething.holidaysomething.dto.ProductOrderInfoDto;
import com.holidaysomething.holidaysomething.dto.ShippingDto;
import com.holidaysomething.holidaysomething.security.MemberUserDetails;
import com.holidaysomething.holidaysomething.service.member.MemberService;
import com.holidaysomething.holidaysomething.service.order.OrderService;
import com.holidaysomething.holidaysomething.service.order.OrderedProductService;
import com.holidaysomething.holidaysomething.service.product.ProductOptionService;
import com.holidaysomething.holidaysomething.service.product.ProductOrderService;
import com.holidaysomething.holidaysomething.service.product.ProductService;
import com.holidaysomething.holidaysomething.service.shipping.ShippingService;
import java.util.ArrayList;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user/product/order")
@Slf4j
@RequiredArgsConstructor
public class UserOrderController {

  private final OrderService orderService;
  private final MemberService memberService;
  private final ProductOrderService productOrderService;
  private final ProductOptionService productOptionService;
  private final ProductService productService;
  private final ShippingService shippingService;
  private final OrderedProductService orderedProductService;

  //주문 버튼을 누르면, orderd_product, order, shipping, payment에 데이터가 추가됨

  /**
   * @Author : Misun Joo 이전페이지(상품상세, 장바구니)로부터 ProductOrderInfoDto, 현재 주문하는 멤버의 정보를 받아와서 Order 페이지에
   * 뿌려줌 PostMapping으로 하는 이유는, GetMapping으로 받아오면 URL에 너무 많은 정보가 표시되며, 길이에 제한도 있기 때문임
   */
  @PostMapping
  public String orderPost(Model model,
      @AuthenticationPrincipal MemberUserDetails userDetails,
      ProductOrderInfoCommand poc) {

    log.info("POC: " + poc.getProductOrderInfoDtos());
    log.info("주문페이지입니다.");

    AddOrderMemberDto addOrderMemberDto = memberService.findMemberById(userDetails.getId());

    // ProductOrderInfoCommand 를 ProductOrderInfo의 리스트로 바꾸어주는 메소드
    // 주문할 상품들의 목록
    List<ProductOrderInfoDto> productOrderInfoDtos = poc.getProductOrderInfoDtos();
    List<ProductOrderDetailDto> productOrderDetailDtos = new ArrayList<>();

    for (ProductOrderInfoDto productOrderInfoDto : productOrderInfoDtos) {
      ProductOrderDetailDto productOrderDetailDto =
          productService.getProductForOrder(productOrderInfoDto.getProductId(),
              productOrderInfoDto.getOptionId(), productOrderInfoDto.getQuantity());
      productOrderDetailDtos.add(productOrderDetailDto);
    }

    model.addAttribute("productOrderInfoDtos", productOrderInfoDtos);
    model.addAttribute("productOrderDetailDtos", productOrderDetailDtos);
    model.addAttribute("addOrderMemberDto", addOrderMemberDto);

    return "user/order";
  }


  /* 주문 Checkout -> Order, Shipping, Ordered_Product 테이블에 각각 값 저장 */
  @PostMapping("/finish")
  public String orderCompletePost(Model model,
      ShippingDto shippingDto,
      ProductOrderInfoCommand poc,
      ProductOrderCompleteDto productOrderCompleteDto,
      @AuthenticationPrincipal MemberUserDetails userDetails) {

    log.info("총 결제금액은  " + productOrderCompleteDto.getOrderTotalPayment());
    log.info("총 마일리지는  " + productOrderCompleteDto.getOrderTotalUseMileage());
    log.info("command 객체의 사이즈는" + poc.getProductOrderInfoDtos().size());

    //주문테이블 등록
    List<ProductOrderInfoDto> orderInfos = productOrderService
        .fromProductOrderInfoCommandToProductOrderInfoList(poc);
    log.info("orderInfos의 사이즈는" + orderInfos.size());
    log.info("orderInfo의 productId는" + orderInfos.get(0).getProductId());

    Long memberId = userDetails.getMember().getId();
    log.info("회원의 아이디는 " + memberId);
    Order order = orderService
        .add(productOrderCompleteDto.getOrderTotalUseMileage(), orderInfos, memberId);

    log.info("오더아이디 " + order.getId());
    log.info("주문번호" + order.getOrderNumber());
    log.info("마일리지" + order.getMileage());
    log.info("금액" + order.getTotalPrice());

    // 주문 등록한 order_id를 받아와야함
    // 주문상품 테이블 등록
    List<OrderedProduct> orderedProducts = orderedProductService.add(order.getId(), orderInfos);

    // 배송테이블 등록
    ShippingDto shippingResult = shippingService.addShipping(shippingDto);

    List<ProductOrderDetailDto> productOrderDetailDtos = new ArrayList<>();

    for (OrderedProduct orderedProduct : orderedProducts) {
      ProductOrderDetailDto productOrderDetailDto =
          productService.getProductForOrder(orderedProduct.getProduct().getId(),
              orderedProduct.getProductOption().getId(), orderedProduct.getQuantity());
      productOrderDetailDtos.add(productOrderDetailDto);
    }

    productOrderCompleteDto.setStatus(ShippingStatus.getValuesByKey(order.getStatus()));

    model.addAttribute("order", order);
    model.addAttribute("productOrderDetailDtos", productOrderDetailDtos);
    model.addAttribute("shipping",shippingResult);
    model.addAttribute("productOrderCompleteDto", productOrderCompleteDto);
    
    return "user/order-complete";
  }
}
