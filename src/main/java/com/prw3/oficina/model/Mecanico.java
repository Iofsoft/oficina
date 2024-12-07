package com.prw3.oficina.model;

import com.prw3.oficina.record.MecanicoDados;
import jakarta.persistence.Embeddable;
import lombok.*;

@Embeddable
@Getter
@Setter
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
