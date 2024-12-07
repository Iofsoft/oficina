package com.prw3.oficina.record;

import jakarta.validation.constraints.NotBlank;

public record AutenticacaoDados(

        @NotBlank
        String login,

        @NotBlank
        String senha
){}
