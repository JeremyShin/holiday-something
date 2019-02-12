package com.holidaysomething.holidaysomething.service.order;

import com.holidaysomething.holidaysomething.domain.Order;
import com.holidaysomething.holidaysomething.domain.Product;
import com.holidaysomething.holidaysomething.domain.ProductOption;
import com.holidaysomething.holidaysomething.domain.constant.ShippingStatus;
import com.holidaysomething.holidaysomething.dto.ProductOrderCompleteDto;
import com.holidaysomething.holidaysomething.dto.ProductOrderDetailDto;
import com.holidaysomething.holidaysomething.dto.ProductOrderInfoDto;
import com.holidaysomething.holidaysomething.repository.MemberRepository;
import com.holidaysomething.holidaysomething.repository.OrderRepository;
import com.holidaysomething.holidaysomething.repository.ProductOptionRepository;
import com.holidaysomething.holidaysomething.repository.ProductRepository;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {
  private final OrderRepository orderRepository;
  private final MemberRepository memberRepository;
  private final ProductRepository productRepository;
  private final ProductOptionRepository productOptionRepository;

  @Override
  public Order add(Integer totalUseMileage,
      List<ProductOrderInfoDto> orderInfos, Long memberId) {
    String currentTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-ddHH:mm:ss"));
    int totalPrice = 0;

    log.info("서비스입니다.");


    //총 결제금액 검색
    for (ProductOrderInfoDto orderInfo : orderInfos){

      log.info("개수" + orderInfo.getQuantity());
      log.info("옵션의 id" + orderInfo.getOptionId());
      log.info("상품의 id" + orderInfo.getProductId());
      Product product = productRepository.getOne(orderInfo.getProductId());

      ProductOption productOption =  productOptionRepository.getOne(orderInfo.getOptionId());

      if ( productOption.getPrice() != null) {
       totalPrice += (product.getSellingPrice() + productOption.getPrice()) * orderInfo.getQuantity();
      } else {
        totalPrice += product.getSellingPrice() * orderInfo.getQuantity();
      }
    }
    int finalPrice = totalPrice - totalUseMileage;

    // 주문번호는 : 현재 날짜및 시간(초까지)  + 00 + 작성자의 아이디번호
    currentTime = currentTime.replace(":", "");
    currentTime = currentTime.replace("-", "");
    currentTime = currentTime.trim();
    String orderNumber = (currentTime + "00" + memberId).trim();

    Order order = new Order();
    order.setOrderNumber(orderNumber);
    order.setDate(LocalDateTime.now());
    order.setTotalPrice(finalPrice);
    order.setMileage(totalUseMileage);
    order.setStatus(ShippingStatus.WAIT_DEPOSIT.getCode()); //1
    order.setMember(memberRepository.getOne(memberId));

    orderRepository.save(order);

    return order;
  }
}
