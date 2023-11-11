package br.com.iagoomes.fiap.parkingcontrol.dto;

import br.com.iagoomes.fiap.parkingcontrol.model.Contrato;
import br.com.iagoomes.fiap.parkingcontrol.model.TipoContrato;
import br.com.iagoomes.fiap.parkingcontrol.model.TipoPagamento;

public record ContratoDto(Long condutor_id, String nomeCondutor, String cpfCondutor, TipoContrato tipoContrato,
                          TipoPagamento tipoPagamento) {
    public ContratoDto(Contrato contratoSave) {
        this(contratoSave.getId(), contratoSave.getCondutor().getNome(), contratoSave.getCondutor().getCpf(), contratoSave.getTipoContrato(), contratoSave.getTipoPagamento());
    }
}
