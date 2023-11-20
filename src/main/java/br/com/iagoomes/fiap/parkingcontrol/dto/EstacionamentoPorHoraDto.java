package br.com.iagoomes.fiap.parkingcontrol.dto;

import br.com.iagoomes.fiap.parkingcontrol.dto.abs.EstacionamentoBaseDto;
import br.com.iagoomes.fiap.parkingcontrol.model.TipoPagamento;
import br.com.iagoomes.fiap.parkingcontrol.model.TipoServico;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class EstacionamentoPorHoraDto extends EstacionamentoBaseDto {
    @NotNull
    @FutureOrPresent
    private final LocalDateTime dataInicio;
    private final TipoServico tipoServico = TipoServico.POR_HORA;

    public EstacionamentoPorHoraDto(Long condutorId, TipoPagamento tipoPagamento, LocalDateTime dataInicio) {
        super(condutorId, tipoPagamento);
        this.dataInicio = dataInicio;
    }
}
