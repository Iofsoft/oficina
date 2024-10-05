package com.prw3.oficina.veiculo;

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

    public Veiculo(VeiculoDados dados) {
        marca = dados.marca();
        modelo = dados.modelo();
        ano = dados.ano();
    }
}
