package com.holidaysomething.holidaysomething.dto;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "CONTENT")
public class Content {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    @CreationTimestamp
    @Column(nullable = false)
    private LocalDateTime regDate;

    @UpdateTimestamp
    @Column(nullable = false)
    private LocalDateTime updateDate;

    @OneToOne
    @JoinColumn(name = "content_body_id")
    private ContentBody contentBody;

    @ManyToOne
    @JoinColumn(name = "content_category_id")
    private ContentCategory contentCategory;
}
