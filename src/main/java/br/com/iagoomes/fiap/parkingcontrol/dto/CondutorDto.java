package br.com.iagoomes.fiap.parkingcontrol.dto;

import br.com.iagoomes.fiap.parkingcontrol.model.Condutor;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record CondutorDto(@NotBlank String nome,
                          @Valid EnderecoDto enderecoDto,
                          @NotBlank
                          @Pattern(regexp = "\\(\\d{2}\\)\\d{5}-\\d{4}", message = "Formato de telefone inválido. O formato deve ser (11)99999-9999.")
                          String telefone,
                          @Email String email) {
    public CondutorDto(Condutor condutorSave) {
        this(condutorSave.getNome(), new EnderecoDto(condutorSave.getEndereco()), condutorSave.getTelefone(), condutorSave.getEmail());
    }
}
