package br.com.iagoomes.fiap.parkingcontrol.controller;

import br.com.iagoomes.fiap.parkingcontrol.dto.CondutorDto;
import br.com.iagoomes.fiap.parkingcontrol.dto.VeiculoDto;
import br.com.iagoomes.fiap.parkingcontrol.dto.VeiculoDtoResponse;
import br.com.iagoomes.fiap.parkingcontrol.service.CondutorService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("condutor")
public class CondutorController {
    private final CondutorService condutorService;

    public CondutorController(CondutorService condutorService) {
        this.condutorService = condutorService;
    }

    @GetMapping("/{id}")
    public ResponseEntity getCondutor(@PathVariable Long id) {
        return condutorService.getCondutor(id);
    }

    @PostMapping
    public ResponseEntity cadastrarCondutor(@Valid @RequestBody CondutorDto condutorDto) {
        return condutorService.cadastrarCondutor(condutorDto);
    }

    @PostMapping("veiculo")
    public ResponseEntity<VeiculoDtoResponse> cadastrarVeiculo(@Valid @RequestBody VeiculoDto veiculoDto) {
        return condutorService.cadastrarVeiculo(veiculoDto);
    }

}
