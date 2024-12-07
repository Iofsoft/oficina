package com.prw3.oficina.record;

import com.prw3.oficina.mecanico.MecanicoDados;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record ConsertoDadosUpdate(

        @NotNull
        Long id,

        @Pattern(regexp = "^(0[1-9]|[12][0-9]|3[01])/(0[1-9]|1[0-2])/\\d{4}$")
        String dataSaida,

        @Valid
        MecanicoDados mecanicoDados
        ) {}
