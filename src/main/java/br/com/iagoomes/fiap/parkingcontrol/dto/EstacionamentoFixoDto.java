package br.com.iagoomes.fiap.parkingcontrol.dto;

import br.com.iagoomes.fiap.parkingcontrol.model.RegistrosEstacionamento;
import br.com.iagoomes.fiap.parkingcontrol.model.TipoServico;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record EstacionamentoFixoDto(@NotNull Long condutorId, @NotNull TipoServico tipoServico,
                                    @NotNull LocalDateTime dataInicio, @NotNull LocalDateTime dataFim) {
    public EstacionamentoFixoDto(RegistrosEstacionamento save) {
        this(save.getId(), save.getTipoServico(), save.getDataInicio(), save.getDataFim());
    }
}
