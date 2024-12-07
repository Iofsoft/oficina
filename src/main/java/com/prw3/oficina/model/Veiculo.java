package com.prw3.oficina.model;

import com.prw3.oficina.record.VeiculoDados;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Veiculo {
    private String marca;
    private String modelo;
    private String ano;
    private String cor;

    public Veiculo(VeiculoDados dados) {
        marca = dados.marca();
        modelo = dados.modelo();
        ano = dados.ano();
        cor = dados.cor();
    }
}
