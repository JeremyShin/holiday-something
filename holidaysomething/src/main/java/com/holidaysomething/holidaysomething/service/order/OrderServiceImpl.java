package com.holidaysomething.holidaysomething.service.order;

import com.holidaysomething.holidaysomething.domain.Order;
import com.holidaysomething.holidaysomething.dto.ProductOrderCompleteDto;
import com.holidaysomething.holidaysomething.dto.ProductOrderDetailDto;
import com.holidaysomething.holidaysomething.repository.MemberRepository;
import com.holidaysomething.holidaysomething.repository.OrderRepository;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {
  private final OrderRepository orderRepository;
  private final MemberRepository memberRepository;

  @Override
  public Order add(ProductOrderCompleteDto productOrderCompleteDto,
      ProductOrderDetailDto productOrderDetailDto) {
    String currentTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));

    log.info("현재시간은" +  currentTime);

    Order order = new Order();
    // 주문번호는 : 현재 날짜및 시간(초까지)  + 00 + 작성자의 아이디번호
    order.setOrderNumber(currentTime + "00" + productOrderCompleteDto.getMemberId());

    order.setDate(LocalDateTime.now());
    order.setTotalPrice(productOrderCompleteDto.getOrderTotalPayment());
    order.setStatus(1);
    order.setMileage(productOrderCompleteDto.getOrderTotalUseMileage());
    order.setMember(memberRepository.getOne(productOrderCompleteDto.getMemberId()));

    orderRepository.save(order);

    return order;
  }
}
