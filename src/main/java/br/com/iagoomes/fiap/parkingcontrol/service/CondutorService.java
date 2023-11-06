package br.com.iagoomes.fiap.parkingcontrol.service;

import br.com.iagoomes.fiap.parkingcontrol.dto.CondutorDto;
import br.com.iagoomes.fiap.parkingcontrol.model.Condutor;
import br.com.iagoomes.fiap.parkingcontrol.repository.CondutorRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class CondutorService {

    private final CondutorRepository condutorRepository;

    public CondutorService(CondutorRepository condutorRepository) {
        this.condutorRepository = condutorRepository;
    }

    public ResponseEntity<CondutorDto> cadastrarCondutor(CondutorDto condutorDto) {
        Condutor condutorSave = condutorRepository.save(new Condutor(condutorDto));
        return ResponseEntity.ok(new CondutorDto(condutorSave));
    }
}
