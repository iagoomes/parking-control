package br.com.iagoomes.fiap.parkingcontrol.dto;

import br.com.iagoomes.fiap.parkingcontrol.model.RegistrosEstacionamento;

public class EstacionamentoFixoResponseDto extends EstacionamentoResponseBaseDto {
    public EstacionamentoFixoResponseDto(RegistrosEstacionamento registrosEstacionamento) {
        super(registrosEstacionamento);
    }
}
