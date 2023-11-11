package br.com.iagoomes.fiap.parkingcontrol.service;

import br.com.iagoomes.fiap.parkingcontrol.dto.*;
import br.com.iagoomes.fiap.parkingcontrol.model.*;
import br.com.iagoomes.fiap.parkingcontrol.repository.CondutorRepository;
import br.com.iagoomes.fiap.parkingcontrol.repository.ContratoRepository;
import br.com.iagoomes.fiap.parkingcontrol.repository.VeiculoRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CondutorService {

    private final CondutorRepository condutorRepository;
    private final VeiculoRepository veiculoRepository;
    private final ContratoRepository contratoRepository;

    public CondutorService(CondutorRepository condutorRepository, VeiculoRepository veiculoRepository, ContratoRepository contratoRepository) {
        this.condutorRepository = condutorRepository;
        this.veiculoRepository = veiculoRepository;
        this.contratoRepository = contratoRepository;
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

    public ResponseEntity cadastrarContrato(CadastroContratoDto cadastroContratoDto) {
        if (cadastroContratoDto.contrato().tipoContrato().equals(TipoContrato.AVULSO)
                & cadastroContratoDto.contrato().tipoPagamento().equals(TipoPagamento.PIX)) {
            return ResponseEntity.badRequest().body("Forma de pagamento PIX só permitida para contratos de locações fixas");
        }
        Optional<Condutor> condutorOptional = condutorRepository.findById(cadastroContratoDto.contrato().condutor_id());
        if (condutorOptional.isEmpty()) {
            return ResponseEntity.badRequest().body("Condutor não cadastrado");
        }

        Condutor condutor = condutorOptional.get();
        if (condutorRepository.existeContratoAtivo(condutor.getId()) == 1) {
            return ResponseEntity.badRequest().body("Cancelar contrato ativo");
        }

        Contrato contrato = new Contrato(cadastroContratoDto);
        contrato.setCondutor(condutor);
        Contrato contratoSave = contratoRepository.save(contrato);

        return ResponseEntity.ok(new ContratoDto(contratoSave));
    }

    public ResponseEntity<List<ContratoDto>> getContrato(Long id) {
        List<Contrato> contratoList = contratoRepository.findByCondutorIdAndAtivo(id, true);
        return ResponseEntity.ok(contratoList.stream().map(ContratoDto::new).toList());
    }
}
