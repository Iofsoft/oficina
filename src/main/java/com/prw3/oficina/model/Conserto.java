package com.prw3.oficina.model;

import com.prw3.oficina.record.ConsertoDados;
import com.prw3.oficina.record.ConsertoDadosUpdate;
import jakarta.persistence.*;
import jakarta.validation.Valid;
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

    private Boolean ativo;

    public Conserto(ConsertoDados dados) {
        ativo = true;
        dataEntrada = dados.dataEntrada();
        dataSaida = dados.dataSaida();
        responsavel = new Mecanico(dados.mecanicoDados());
        veiculo = new Veiculo(dados.veiculoDados());
    }

    public void atualizarDados(@Valid ConsertoDadosUpdate dados) {
        dataSaida = dados.dataSaida();
        responsavel.setNome(dados.mecanicoDados().nome());
        responsavel.setExperiencia(
                dados.mecanicoDados().experiencia() == 0 ? responsavel.getExperiencia() : dados.mecanicoDados().experiencia());
    }

    public void excluir() {
        ativo = false;
    }
}
