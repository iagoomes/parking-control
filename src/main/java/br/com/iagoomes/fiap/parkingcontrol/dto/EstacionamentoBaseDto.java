package br.com.iagoomes.fiap.parkingcontrol.dto;

import br.com.iagoomes.fiap.parkingcontrol.model.TipoPagamento;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class EstacionamentoBaseDto {
    @NotNull
    private final Long condutorId;
    private final TipoPagamento tipoPagamento;

    protected EstacionamentoBaseDto(Long condutorId, TipoPagamento tipoPagamento) {
        this.condutorId = condutorId;
        this.tipoPagamento = tipoPagamento;
    }
}
