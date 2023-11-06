package br.com.iagoomes.fiap.parkingcontrol.dto;

import br.com.iagoomes.fiap.parkingcontrol.model.Condutor;

public record CondutorDtoResponse(Long id, String cpf, String nome, EnderecoDto enderecoDto, String telefone,
                                  String email) {
    public CondutorDtoResponse(Condutor condutorSave) {
        this(condutorSave.getId(), condutorSave.getCpf(), condutorSave.getNome(), new EnderecoDto(condutorSave.getEndereco()), condutorSave.getTelefone(), condutorSave.getEmail());
    }
}
