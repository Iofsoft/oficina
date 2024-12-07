package com.prw3.oficina.record;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record VeiculoDados (

        @NotBlank
        String marca,

        @NotBlank
        String modelo,

        @Pattern(regexp = "^\\d{4}$")
        String ano,

        String cor
        ) {}
