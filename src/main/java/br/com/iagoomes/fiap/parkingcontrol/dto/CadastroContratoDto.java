package br.com.iagoomes.fiap.parkingcontrol.dto;

import jakarta.validation.constraints.NotNull;

public record CadastroContratoDto(@NotNull ContratoDto contrato) {
}
