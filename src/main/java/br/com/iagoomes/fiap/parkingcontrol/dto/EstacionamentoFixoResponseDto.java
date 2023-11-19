package br.com.iagoomes.fiap.parkingcontrol.dto;

import br.com.iagoomes.fiap.parkingcontrol.model.RegistrosEstacionamento;
import br.com.iagoomes.fiap.parkingcontrol.model.TipoPagamento;
import br.com.iagoomes.fiap.parkingcontrol.model.TipoServico;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record EstacionamentoFixoResponseDto(Long condutorId, TipoServico tipoServico,
                                            TipoPagamento tipoPagamento,
                                            LocalDateTime dataInicio, LocalDateTime dataFim,
                                            BigDecimal valor) {
    public EstacionamentoFixoResponseDto(RegistrosEstacionamento save) {
        this(save.getId(), save.getTipoServico(), save.getTipoPagamento(), save.getDataInicio(), save.getDataFim(), save.getValor());
    }
}
