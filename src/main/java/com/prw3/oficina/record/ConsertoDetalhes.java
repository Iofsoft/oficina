package com.prw3.oficina.record;

import com.prw3.oficina.model.Conserto;
import com.prw3.oficina.mecanico.Mecanico;
import com.prw3.oficina.model.Veiculo;

public record ConsertoDetalhes(Long id,
                               String dataEntrada,
                               String dataSaida,
                               Mecanico responsavel,
                               Veiculo veiculo,
                               Boolean ativo) {
    public ConsertoDetalhes(Conserto conserto) {
        this(
                conserto.getId(),
                conserto.getDataEntrada(),
                conserto.getDataSaida(),
                conserto.getResponsavel(),
                conserto.getVeiculo(),
                conserto.getAtivo()
        );
    }
}
