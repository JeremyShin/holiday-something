package com.holidaysomething.holidaysomething.dto;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "CONTENT_CATEGORIES")
@Getter
@Setter
public class ContentCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Long parentId;  // TODO : Long 일 필요가 있을까?

    @OneToMany(mappedBy = "contentCategory")
    private Set<Content> contents;

}