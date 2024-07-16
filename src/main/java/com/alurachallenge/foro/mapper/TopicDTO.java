package com.alurachallenge.foro.mapper;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.time.LocalDateTime;

public record TopicDTO(
        @NotBlank(message = "Titulo no puede ser null")
        String title,
        @NotBlank
        @Size(min = 10, max = 200, message
                = "About Me must be between 10 and 200 characters")
        String  message,
        Boolean status,
        @NotBlank(message = "Curso relacionado no puede ser null")
        String relatedCourse,
        LocalDateTime createdDate
) {

}
