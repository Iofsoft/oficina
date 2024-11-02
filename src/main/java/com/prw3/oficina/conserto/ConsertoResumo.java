package com.prw3.oficina.conserto;

public record ConsertoResumo(Long id,
                             String dataEntrada,
                             String dataSaida,
                             String nome,
                             String marca,
                             String modelo) {

    public ConsertoResumo (Conserto conserto) {
        this(
            conserto.getId(),
            conserto.getDataEntrada(),
            conserto.getDataSaida(),
            conserto.getResponsavel().getNome(),
            conserto.getVeiculo().getMarca(),
            conserto.getVeiculo().getModelo()
        );
    }
}


