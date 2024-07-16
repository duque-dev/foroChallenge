package com.alurachallenge.foro.domain.mapper;

import jakarta.validation.constraints.NotBlank;

public record ClientAuthDataDTO(

        String userName,

        String password
) {
}
