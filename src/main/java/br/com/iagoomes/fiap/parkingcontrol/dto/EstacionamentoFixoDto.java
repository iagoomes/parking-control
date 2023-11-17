package br.com.iagoomes.fiap.parkingcontrol.dto;

import br.com.iagoomes.fiap.parkingcontrol.model.RegistrosEstacionamento;
import br.com.iagoomes.fiap.parkingcontrol.model.TipoPagamento;
import br.com.iagoomes.fiap.parkingcontrol.model.TipoServico;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record EstacionamentoFixoDto(@NotNull Long condutorId, @NotNull TipoServico tipoServico,
                                    TipoPagamento tipoPagamento,
                                    @NotNull LocalDateTime dataInicio, @NotNull LocalDateTime dataFim,
                                    BigDecimal valor) {
    public EstacionamentoFixoDto(RegistrosEstacionamento save) {
        this(save.getId(), save.getTipoServico(), save.getTipoPagamento(), save.getDataInicio(), save.getDataFim(), save.getValor());
    }
}
