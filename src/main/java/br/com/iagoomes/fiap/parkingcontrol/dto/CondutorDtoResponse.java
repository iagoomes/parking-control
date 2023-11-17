package br.com.iagoomes.fiap.parkingcontrol.dto;

import br.com.iagoomes.fiap.parkingcontrol.model.Condutor;
import br.com.iagoomes.fiap.parkingcontrol.model.TipoPagamento;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record CondutorDtoResponse(Long id, String nome, TipoPagamento tipoPagamento, String cpf,
                                  EnderecoDto enderecoDto, String telefone,
                                  String email) {
    public CondutorDtoResponse(Condutor condutorSave) {
        this(condutorSave.getId(), condutorSave.getNome(), condutorSave.getTipoPagamento(), condutorSave.getCpf(), new EnderecoDto(condutorSave.getEndereco()), condutorSave.getTelefone(), condutorSave.getEmail());
    }
}
