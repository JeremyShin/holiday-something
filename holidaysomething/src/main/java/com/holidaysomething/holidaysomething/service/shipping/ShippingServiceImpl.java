package com.holidaysomething.holidaysomething.service.shipping;

import com.holidaysomething.holidaysomething.domain.Shipping;
import com.holidaysomething.holidaysomething.dto.ShippingDto;
import com.holidaysomething.holidaysomething.repository.ShippingRepository;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class ShippingServiceImpl implements ShippingService {

  private final ShippingRepository shippingRepository;

  @Override
  public ShippingDto addShipping(ShippingDto shippingDto) {
    String currentTime = LocalDateTime.now()
        .format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
    currentTime = currentTime.replace(":", "");
    currentTime = currentTime.replace("-", "");
    currentTime = currentTime.trim();

    Shipping shipping = new Shipping();
    shipping.setRecipient(shippingDto.getOrderRecipientNameInput());
    shipping.setAddress(shippingDto.getOrderRecipientAddress1Input());
    shipping.setAddressDetail(shippingDto.getOrderRecipientAddress2Input());
    shipping.setPhone(shippingDto.getOrderRecipientPhoneInput());
    shipping.setPostcode(shippingDto.getOrderRecipientPostcodeInput());
    shipping.setMessage(shippingDto.getOrderRecipientMessageInput());
    shipping.setShippingPrice(shippingDto.getOrderTotalShippingPrice());
    shipping.setShippingNumber(currentTime);

    shippingRepository.save(shipping);

    ShippingDto shippingDto1 = new ShippingDto();
    shippingDto1.setOrderRecipientNameInput(shipping.getRecipient());
    shippingDto1.setOrderRecipientAddress1Input(shipping.getAddress());
    shippingDto1.setOrderRecipientAddress2Input(shipping.getAddressDetail());
    shippingDto1.setOrderRecipientPhoneInput(shipping.getPhone());
    shippingDto1.setOrderRecipientPostcodeInput(shipping.getPostcode());
    shippingDto1.setOrderRecipientMessageInput(shipping.getMessage());
    shippingDto1.setOrderTotalShippingPrice(shipping.getShippingPrice());

    return shippingDto1;
  }
}
