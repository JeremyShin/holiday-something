package com.holidaysomething.holidaysomething.dto;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;


@Getter @Setter
@Entity
@Table(name = "CONTENT_BODIES")
public class ContentBody {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String image_url;
    private String video_url;

    @OneToOne(mappedBy = "contentBody")
    private Content content;
}
