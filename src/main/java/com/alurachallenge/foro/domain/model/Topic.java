package com.alurachallenge.foro.domain.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "topics")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties
@ToString
public class Topic {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    @Column(nullable = false, unique = true)
    private String title;
    @Column(nullable = false, unique = true)
    private  String  message;
    private Boolean status;
    @Column(nullable = false)
    private String relatedCourse;
    @Column(nullable = false)
    private LocalDateTime createdDate;


    public Topic(String title, String message, Boolean status, String relatedCourse, LocalDateTime createdDate) {
        this.title = title;
        this.message = message;
        this.status = true;
        this.relatedCourse = relatedCourse;
        this.createdDate = LocalDateTime.now();
    }

}

