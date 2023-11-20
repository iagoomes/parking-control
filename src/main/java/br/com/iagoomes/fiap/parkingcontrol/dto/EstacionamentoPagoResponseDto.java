package br.com.iagoomes.fiap.parkingcontrol.dto;

import br.com.iagoomes.fiap.parkingcontrol.model.RegistrosEstacionamento;

import java.math.BigDecimal;

public record EstacionamentoPagoResponseDto(Long registroId, Long condutorId, BigDecimal valor) {
    public EstacionamentoPagoResponseDto(RegistrosEstacionamento estacionamento) {
        this(estacionamento.getId(), estacionamento.getCondutor().getId(), estacionamento.getValor());
    }
}
