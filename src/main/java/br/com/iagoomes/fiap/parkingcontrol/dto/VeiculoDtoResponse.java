package br.com.iagoomes.fiap.parkingcontrol.dto;

import br.com.iagoomes.fiap.parkingcontrol.model.Veiculo;

public record VeiculoDtoResponse(Long id, String marca, String modelo, String cor, int ano,
                                 String placa, Long condutorId) {
    public VeiculoDtoResponse(Veiculo veiculoSave) {
        this(veiculoSave.getId(), veiculoSave.getMarca(), veiculoSave.getModelo(), veiculoSave.getCor(), veiculoSave.getAno(), veiculoSave.getPlaca(), veiculoSave.getCondutor().getId());
    }
}
