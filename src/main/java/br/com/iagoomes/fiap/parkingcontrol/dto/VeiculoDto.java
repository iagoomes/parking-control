package br.com.iagoomes.fiap.parkingcontrol.dto;

import br.com.iagoomes.fiap.parkingcontrol.model.Veiculo;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record VeiculoDto(@NotBlank String marca, @NotBlank String modelo, @NotBlank String cor, int ano,
                         @NotBlank String placa, @NotNull Long condutorId) {
    public VeiculoDto(Veiculo veiculoSave) {
        this(veiculoSave.getMarca(), veiculoSave.getModelo(), veiculoSave.getCor(), veiculoSave.getAno(), veiculoSave.getPlaca(), veiculoSave.getCondutor().getId());
    }
}
