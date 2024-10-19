package com.prw3.oficina.conserto;

public record ConsertoResumo(String dataEntrada,
                             String dataSaida,
                             String nome,
                             String marca,
                             String modelo) {

    public ConsertoResumo (Conserto conserto) {
        this(conserto.getDataEntrada(),
                conserto.getDataSaida(),
                conserto.getResponsavel().getNome(),
                conserto.getVeiculo().getMarca(),
                conserto.getVeiculo().getModelo()
                );
    }
}


