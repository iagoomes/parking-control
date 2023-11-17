package br.com.iagoomes.fiap.parkingcontrol.controller;

import br.com.iagoomes.fiap.parkingcontrol.dto.EstacionamentoFixoDto;
import br.com.iagoomes.fiap.parkingcontrol.service.ParquimetroService;
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

    @PostMapping
    public ResponseEntity iniciarEstacionamentoFixo(@RequestBody EstacionamentoFixoDto inicioEstacionamentoFixoDto) {
        return parquimetroService.iniciarEstacionamento(inicioEstacionamentoFixoDto);
    }
}
