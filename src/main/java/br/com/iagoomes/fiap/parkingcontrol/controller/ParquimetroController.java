package br.com.iagoomes.fiap.parkingcontrol.controller;

import br.com.iagoomes.fiap.parkingcontrol.dto.EstacionamentoFixoDto;
import br.com.iagoomes.fiap.parkingcontrol.dto.EstacionamentoPorHoraDto;
import br.com.iagoomes.fiap.parkingcontrol.service.ParquimetroService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("parquimetro")
public class ParquimetroController {
    private final ParquimetroService parquimetroService;

    public ParquimetroController(ParquimetroService parquimetroService) {
        this.parquimetroService = parquimetroService;
    }

    @PostMapping("fixo")
    public ResponseEntity iniciarEstacionamentoFixo(@RequestBody @Valid EstacionamentoFixoDto inicioEstacionamentoFixoDto) {
        return parquimetroService.iniciarEstacionamentoFixo(inicioEstacionamentoFixoDto);
    }

    @PostMapping("porhora")
    public ResponseEntity iniciarEstacionamentoPorHora(@RequestBody @Valid EstacionamentoPorHoraDto estacionamentoPorHoraDto) {
        return parquimetroService.iniciarEstacionamentoPorHora(estacionamentoPorHoraDto);
    }

    public ResponseEntity encerrarEstacionamento() {
        return null;
    }
}
