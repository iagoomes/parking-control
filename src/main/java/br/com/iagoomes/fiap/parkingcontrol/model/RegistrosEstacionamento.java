package br.com.iagoomes.fiap.parkingcontrol.model;

import br.com.iagoomes.fiap.parkingcontrol.dto.EstacionamentoFixoDto;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity(name = "RegistrosEstacionamento")
@Table(name = "registros_Estacionamento")
public class RegistrosEstacionamento {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SPK_RegistrosEstacionamento")
    @SequenceGenerator(name = "SPK_RegistrosEstacionamento", sequenceName = "SPK_RegistrosEstacionamento_bd", allocationSize = 1)
    private Long id;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "condutor_id")
    private Condutor condutor;

    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_pagamento")
    private TipoPagamento tipoPagamento;

    @Column(name = "tipo_servico")
    private TipoServico tipoServico;

    @Column(name = "data_inicio")
    private LocalDateTime dataInicio;

    @Column(name = "data_fim")
    private LocalDateTime dataFim;

    public RegistrosEstacionamento(EstacionamentoFixoDto estacionamentoFixoDto) {
        this.tipoServico = estacionamentoFixoDto.tipoServico();
        this.dataInicio = estacionamentoFixoDto.dataInicio();
        this.dataFim = estacionamentoFixoDto.dataFim();
    }
}
