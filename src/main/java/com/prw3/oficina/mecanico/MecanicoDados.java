package com.prw3.oficina.mecanico;

import jakarta.validation.constraints.NotBlank;

public record MecanicoDados(
        @NotBlank
        String nome,

        int experiencia
        ) {}
