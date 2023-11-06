package br.com.iagoomes.fiap.parkingcontrol.controller;

import br.com.iagoomes.fiap.parkingcontrol.dto.CondutorDto;
import br.com.iagoomes.fiap.parkingcontrol.service.CondutorService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("condutor")
public class ParkingController {
    private final CondutorService condutorService;

    public ParkingController(CondutorService condutorService) {
        this.condutorService = condutorService;
    }

    @PostMapping
    public ResponseEntity<CondutorDto> cadastrarCondutor(@Valid @RequestBody CondutorDto condutorDto) {
        return condutorService.cadastrarCondutor(condutorDto);
    }

//    @PostMapping("veiculo")
//    public ResponseEntity<CondutorDto> cadastroVeiculo(@Valid @RequestBody VeiculoDto veiculoDto){
//
//    }
}
