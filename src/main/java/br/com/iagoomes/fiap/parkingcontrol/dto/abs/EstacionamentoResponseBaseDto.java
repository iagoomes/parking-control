package br.com.iagoomes.fiap.parkingcontrol.dto.abs;

import br.com.iagoomes.fiap.parkingcontrol.model.RegistrosEstacionamento;
import br.com.iagoomes.fiap.parkingcontrol.model.TipoPagamento;
import br.com.iagoomes.fiap.parkingcontrol.model.TipoServico;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
@Getter
@Setter
public abstract class EstacionamentoResponseBaseDto {
    public final Long condutorId;
    public final Long registroId;
    public final TipoPagamento tipoPagamento;
    public final TipoServico tipoServico;
    public final LocalDateTime dataInicio;
    public final LocalDateTime dataFim;

    public EstacionamentoResponseBaseDto(RegistrosEstacionamento registrosEstacionamento) {
        this.condutorId = registrosEstacionamento.getCondutor().getId();
        this.registroId = registrosEstacionamento.getId();
        this.tipoPagamento = registrosEstacionamento.getTipoPagamento();
        this.tipoServico = registrosEstacionamento.getTipoServico();
        this.dataInicio = registrosEstacionamento.getDataInicio();
        this.dataFim = registrosEstacionamento.getDataFim();
    }
}
