package com.holidaysomething.holidaysomething.service.shipping;

import com.holidaysomething.holidaysomething.domain.Shipping;
import com.holidaysomething.holidaysomething.dto.ShippingDto;
import com.holidaysomething.holidaysomething.repository.ShippingRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ModelAttribute;

@Service
@Slf4j
@RequiredArgsConstructor
public class ShippingServiceImpl implements ShippingService{
  private final ShippingRepository shippingRepository;

  @Override
  public void addShipping(ShippingDto shippingDto) {
    Shipping shipping = new Shipping();
    shipping.setRecipient(shippingDto.getOrderRecipientNameInput());
    shipping.setAddress(shippingDto.getOrderRecipientAddress1Input());
    shipping.setAddressDetail(shippingDto.getOrderRecipientAddress2Input());
    shipping.setPhone(shippingDto.getOrderRecipientPhoneInput());
    shipping.setPostcode(shippingDto.getOrderRecipientPostcodeInput());
    shipping.setMessage(shippingDto.getOrderRecipientMessageInput());
    shipping.setShippingPrice(shippingDto.getOrderTotalShippingPrice());

    //배송번호를 어떻게 해줄 것인가?
    shipping.setShippingNumber("1");
    //배송 시작 날짜
    //배송 완료 날짜

    shippingRepository.save(shipping);
  }
}
