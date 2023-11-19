package br.com.iagoomes.fiap.parkingcontrol.dto;

import br.com.iagoomes.fiap.parkingcontrol.model.TipoPagamento;
import br.com.iagoomes.fiap.parkingcontrol.model.TipoServico;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record EstacionamentoPorHoraDto(Long condutorId,
                                       TipoPagamento tipoPagamento,
                                       @NotNull @FutureOrPresent LocalDateTime dataInicio) {
    public static final TipoServico tipoServico = TipoServico.FIXO;
}
