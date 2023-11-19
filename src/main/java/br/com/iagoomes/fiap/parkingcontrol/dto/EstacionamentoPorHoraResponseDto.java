package br.com.iagoomes.fiap.parkingcontrol.dto;

import br.com.iagoomes.fiap.parkingcontrol.model.RegistrosEstacionamento;
import br.com.iagoomes.fiap.parkingcontrol.model.TipoPagamento;
import br.com.iagoomes.fiap.parkingcontrol.model.TipoServico;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record EstacionamentoPorHoraResponseDto(Long condutorId, TipoPagamento tipoPagamento, TipoServico tipoServico,
                                               @NotNull @FutureOrPresent LocalDateTime dataInicio) {
    public EstacionamentoPorHoraResponseDto(RegistrosEstacionamento save) {
        this(save.getId(), save.getTipoPagamento(), save.getTipoServico(), save.getDataInicio());
    }
}
