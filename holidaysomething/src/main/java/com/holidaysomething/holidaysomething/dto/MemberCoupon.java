package com.holidaysomething.holidaysomething.dto;

import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;

@Getter
@Setter
public class MemberCoupon {
    private Long memberId;
    private Long couponId;
    private LocalDateTime startDate;
    private LocalDateTime expireDate;
}
