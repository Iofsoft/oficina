package com.prw3.oficina.mecanico;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Mecanico {
    private String nome;
    private int experiencia;

    public Mecanico(MecanicoDados dados) {
        nome = dados.nome();
        experiencia = dados.experiencia();
    }
}
