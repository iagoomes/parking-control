package br.com.iagoomes.fiap.parkingcontrol.service;

import br.com.iagoomes.fiap.parkingcontrol.dto.CondutorDto;
import br.com.iagoomes.fiap.parkingcontrol.dto.CondutorDtoResponse;
import br.com.iagoomes.fiap.parkingcontrol.dto.VeiculoDto;
import br.com.iagoomes.fiap.parkingcontrol.dto.VeiculoDtoResponse;
import br.com.iagoomes.fiap.parkingcontrol.model.Condutor;
import br.com.iagoomes.fiap.parkingcontrol.model.Veiculo;
import br.com.iagoomes.fiap.parkingcontrol.repository.CondutorRepository;
import br.com.iagoomes.fiap.parkingcontrol.repository.VeiculoRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CondutorService {

    private final CondutorRepository condutorRepository;
    private final VeiculoRepository veiculoRepository;

    public CondutorService(CondutorRepository condutorRepository, VeiculoRepository veiculoRepository) {
        this.condutorRepository = condutorRepository;
        this.veiculoRepository = veiculoRepository;
    }

    public ResponseEntity getCondutor(Long id) {
        Optional<Condutor> condutorOptional = condutorRepository.findById(id);
        if (condutorOptional.isEmpty()) {
            return ResponseEntity.badRequest().body("ID não cadastrado");
        }
        return ResponseEntity.ok(new CondutorDtoResponse(condutorOptional.get()));
    }

    public ResponseEntity cadastrarCondutor(CondutorDto condutorDto) {
        int exist = condutorRepository.findByCpf(condutorDto.cpf());
        if (exist == 1) {
            return ResponseEntity.badRequest().body("CPF já utilizado por outro cadastro");
        }
        Condutor condutorSave = condutorRepository.save(new Condutor(condutorDto));
        return ResponseEntity.ok(new CondutorDtoResponse(condutorSave));
    }

    public ResponseEntity<VeiculoDtoResponse> cadastrarVeiculo(VeiculoDto veiculoDto) {
        Optional<Condutor> byId = condutorRepository.findById(veiculoDto.condutorId());
        if (byId.isEmpty()) {
            return ResponseEntity.badRequest().build();
        }
        Veiculo veiculo = new Veiculo(veiculoDto);
        veiculo.setCondutor(byId.get());
        Veiculo veiculoSave = veiculoRepository.save(veiculo);
        return ResponseEntity.ok(new VeiculoDtoResponse(veiculoSave));
    }

}
