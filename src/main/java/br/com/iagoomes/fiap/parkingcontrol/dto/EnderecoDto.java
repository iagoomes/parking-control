package br.com.iagoomes.fiap.parkingcontrol.dto;

import br.com.iagoomes.fiap.parkingcontrol.model.Endereco;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
@JsonInclude(JsonInclude.Include.NON_NULL)
public record EnderecoDto(@NotBlank String logradouro, @NotBlank String bairro,
                          @NotBlank @Pattern(regexp = "\\d{8}") String cep, String numero, String complemento,
                          @NotBlank String cidade, @NotBlank String uf) {
    public EnderecoDto(Endereco endereco) {
        this(endereco.getLogradouro(), endereco.getBairro(), endereco.getCep(), endereco.getNumero(), endereco.getComplemento(), endereco.getCidade(), endereco.getUf());
    }
}
