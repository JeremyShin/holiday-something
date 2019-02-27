package com.holidaysomething.holidaysomething.dto;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import java.time.LocalDateTime;

@Data
public class MemberAddDto {

    @NotEmpty(message = "login id must be not null")
    private String loginId;

    @NotEmpty(message = "password must be not null")
    private String password;

    @NotEmpty(message = "email must be not null")
    private String email;

    @NotEmpty(message = "name must be not null")
    private String name;

    @NotEmpty(message = "please make me! nickname")
    private String nickname;

    @NotEmpty(message = "please make me! phone")
    private String phone;
    private int mileage;
    private String birthday;
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

    @NotEmpty(message = "sex must be not null")
    private String sex;

}
