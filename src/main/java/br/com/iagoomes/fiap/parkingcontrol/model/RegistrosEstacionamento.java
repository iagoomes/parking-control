package br.com.iagoomes.fiap.parkingcontrol.model;

import br.com.iagoomes.fiap.parkingcontrol.dto.EstacionamentoFixoDto;
import br.com.iagoomes.fiap.parkingcontrol.dto.EstacionamentoPorHoraDto;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity(name = "RegistrosEstacionamento")
@Table(name = "registros_Estacionamento")
public class RegistrosEstacionamento {

    public static BigDecimal valorPorHora = new BigDecimal("15.0");

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
    @Enumerated(EnumType.STRING)
    private TipoServico tipoServico;

    @Column(name = "data_inicio")
    private LocalDateTime dataInicio;

    @Column(name = "data_fim")
    private LocalDateTime dataFim;

    private BigDecimal valor;

    private Boolean status;

    public RegistrosEstacionamento(EstacionamentoFixoDto estacionamentoFixoDto) {
        this.tipoPagamento = estacionamentoFixoDto.getTipoPagamento();
        this.tipoServico = estacionamentoFixoDto.getTipoServico();
        this.dataInicio = estacionamentoFixoDto.getDataInicio();
        this.dataFim = estacionamentoFixoDto.getDataFim();
    }

    public RegistrosEstacionamento(EstacionamentoPorHoraDto estacionamentoPorHoraDto) {
        this.tipoPagamento = estacionamentoPorHoraDto.getTipoPagamento();
        this.tipoServico = estacionamentoPorHoraDto.getTipoServico();
        this.dataInicio = estacionamentoPorHoraDto.getDataInicio();
    }
}
