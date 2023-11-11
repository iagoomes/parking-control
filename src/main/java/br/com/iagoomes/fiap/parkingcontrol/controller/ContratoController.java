package br.com.iagoomes.fiap.parkingcontrol.controller;

import br.com.iagoomes.fiap.parkingcontrol.dto.CadastroContratoDto;
import br.com.iagoomes.fiap.parkingcontrol.dto.ContratoDto;
import br.com.iagoomes.fiap.parkingcontrol.service.CondutorService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("contrato")
public class ContratoController {
    private final CondutorService condutorService;

    public ContratoController(CondutorService condutorService) {
        this.condutorService = condutorService;
    }

    @PostMapping()
    public ResponseEntity cadastrarContrato(@Valid @RequestBody CadastroContratoDto cadastroContratoDto) {
        return condutorService.cadastrarContrato(cadastroContratoDto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<List<ContratoDto>> getContrato(@PathVariable Long id) {
        return condutorService.getContrato(id);
    }
}
