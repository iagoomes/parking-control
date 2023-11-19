package br.com.iagoomes.fiap.parkingcontrol.dto;

import br.com.iagoomes.fiap.parkingcontrol.model.RegistrosEstacionamento;
import br.com.iagoomes.fiap.parkingcontrol.model.TipoPagamento;
import br.com.iagoomes.fiap.parkingcontrol.model.TipoServico;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record EstacionamentoFixoDto(@NotNull Long condutorId,
                                    TipoPagamento tipoPagamento, @NotNull @FutureOrPresent LocalDateTime dataInicio,
                                    @NotNull @FutureOrPresent LocalDateTime dataFim) {

    public static final TipoServico tipoServico = TipoServico.FIXO;
    public EstacionamentoFixoDto(RegistrosEstacionamento save) {
        this(save.getId(), save.getTipoPagamento(), save.getDataInicio(), save.getDataFim());
    }
}
