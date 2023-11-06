package br.com.iagoomes.fiap.parkingcontrol.model;

import br.com.iagoomes.fiap.parkingcontrol.dto.EnderecoDto;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Endereco {
    private String logradouro;
    private String bairro;
    private String cep;
    private String numero;
    private String complemento;
    private String cidade;
    private String uf;

    public Endereco(EnderecoDto enderecoDto) {
        this.logradouro = enderecoDto.logradouro();
        this.bairro = enderecoDto.bairro();
        this.cep = enderecoDto.cep();
        this.numero = enderecoDto.numero();
        this.complemento = enderecoDto.complemento();
        this.cidade = enderecoDto.cidade();
        this.uf = enderecoDto.uf();
    }
}
