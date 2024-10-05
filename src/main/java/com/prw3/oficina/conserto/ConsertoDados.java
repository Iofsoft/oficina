package com.prw3.oficina.conserto;

import com.prw3.oficina.mecanico.MecanicoDados;
import com.prw3.oficina.veiculo.VeiculoDados;

public record ConsertoDados(String dataEntrada,
                            String dataSaida,
                            MecanicoDados mecanicoDados,
                            VeiculoDados veiculoDados) {
}
