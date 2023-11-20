package br.com.iagoomes.fiap.parkingcontrol.dto;

import br.com.iagoomes.fiap.parkingcontrol.model.RegistrosEstacionamento;

import java.math.BigDecimal;

public record EstacionamentoPagoResponseDTO(Long registroId, Long condutorId, BigDecimal valor) {
    public EstacionamentoPagoResponseDTO(RegistrosEstacionamento estacionamento) {
        this(estacionamento.getId(), estacionamento.getCondutor().getId(), estacionamento.getValor());
    }
}
