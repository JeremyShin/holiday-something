package com.holidaysomething.holidaysomething.dto;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.Date;

@Data
public class MemberAddDto {

    private Long id;
    private String loginId;
    private String password;
    private String email;
    private String name;
    private String nickName;
    private String phone;
    private int mileage;
    private Date birthday;
    private String postcode;
    private String address1;
    private String address2;
    private LocalDateTime lastLogin;
    private LocalDateTime regDate;
    private boolean receiveEmail;
    private boolean receiveSms;
    private boolean marketing;
    private boolean personalInfo;
    private String recommender;
    private String sex;

}
