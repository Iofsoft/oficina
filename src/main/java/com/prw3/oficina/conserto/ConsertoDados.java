package com.prw3.oficina.conserto;

import com.prw3.oficina.mecanico.MecanicoDados;
import com.prw3.oficina.veiculo.VeiculoDados;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Pattern;

public record ConsertoDados(

        @Pattern(regexp = "^(0[1-9]|[12][0-9]|3[01])/(0[1-9]|1[0-2])/\\d{4}$")
        String dataEntrada,

        @Pattern(regexp = "^(0[1-9]|[12][0-9]|3[01])/(0[1-9]|1[0-2])/\\d{4}$")
        String dataSaida,

        @Valid
        MecanicoDados mecanicoDados,

        @Valid
        VeiculoDados veiculoDados) {
}
