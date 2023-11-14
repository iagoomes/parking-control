package br.com.iagoomes.fiap.parkingcontrol.controller;

import br.com.iagoomes.fiap.parkingcontrol.dto.EstacionamentoFixoDto;
import br.com.iagoomes.fiap.parkingcontrol.service.GerenciamentoDeTempoService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("parquimetro")
public class ParquimetroController {
    private final GerenciamentoDeTempoService gerenciamentoDeTempoService;

    public ParquimetroController(GerenciamentoDeTempoService gerenciamentoDeTempoService) {
        this.gerenciamentoDeTempoService = gerenciamentoDeTempoService;
    }

    @PostMapping
    public ResponseEntity iniciarEstacionamentoFixo(@RequestBody EstacionamentoFixoDto inicioEstacionamentoFixoDto) {
        return gerenciamentoDeTempoService.iniciarEstacionamentoFixo(inicioEstacionamentoFixoDto);
    }
}
