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
public class EstacionamentoFixoDto extends EstacionamentoBaseDto {
    @NotNull
    @FutureOrPresent
    private final LocalDateTime dataInicio;
    @NotNull
    @FutureOrPresent
    private final LocalDateTime dataFim;
    private final TipoServico tipoServico = TipoServico.FIXO;

    public EstacionamentoFixoDto(Long condutorId, TipoPagamento tipoPagamento, LocalDateTime dataInicio, LocalDateTime dataFim) {
        super(condutorId, tipoPagamento);
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
    }
}
