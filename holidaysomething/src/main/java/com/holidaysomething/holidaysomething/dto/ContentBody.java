package com.holidaysomething.holidaysomething.dto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class ContentBody {
    private Long id;
    private String image_url;
    private String video_url;
    private Long contentId;
}
