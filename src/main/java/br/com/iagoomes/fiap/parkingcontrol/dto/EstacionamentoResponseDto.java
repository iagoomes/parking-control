package br.com.iagoomes.fiap.parkingcontrol.dto;

import br.com.iagoomes.fiap.parkingcontrol.dto.abs.EstacionamentoResponseBaseDto;
import br.com.iagoomes.fiap.parkingcontrol.model.RegistrosEstacionamento;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class EstacionamentoResponseDto extends EstacionamentoResponseBaseDto {
    public EstacionamentoResponseDto(RegistrosEstacionamento registrosEstacionamento) {
        super(registrosEstacionamento);
    }
}
