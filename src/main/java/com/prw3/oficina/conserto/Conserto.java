package com.prw3.oficina.conserto;

import com.prw3.oficina.mecanico.Mecanico;
import com.prw3.oficina.veiculo.Veiculo;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table
@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Conserto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String dataEntrada;
    private String dataSaida;

    @Embedded
    private Mecanico responsavel;

    @Embedded
    private Veiculo veiculo;

    public Conserto(ConsertoDados dados) {
        dataEntrada = dados.dataEntrada();
        dataSaida = dados.dataSaida();
        responsavel = new Mecanico(dados.mecanicoDados());
        veiculo = new Veiculo(dados.veiculoDados());
    }
}
