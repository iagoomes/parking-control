package br.com.iagoomes.fiap.parkingcontrol.service;

import br.com.iagoomes.fiap.parkingcontrol.dto.EstacionamentoFixoDto;
import br.com.iagoomes.fiap.parkingcontrol.model.Condutor;
import br.com.iagoomes.fiap.parkingcontrol.model.RegistrosEstacionamento;
import br.com.iagoomes.fiap.parkingcontrol.model.TipoPagamento;
import br.com.iagoomes.fiap.parkingcontrol.model.TipoServico;
import br.com.iagoomes.fiap.parkingcontrol.repository.CondutorRepository;
import br.com.iagoomes.fiap.parkingcontrol.repository.RegistrosEstacionamentosRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class GerenciamentoDeTempoService {
    private final RegistrosEstacionamentosRepository registrosEstacionamentosRepository;
    private final CondutorRepository condutorRepository;

    public GerenciamentoDeTempoService(RegistrosEstacionamentosRepository registrosEstacionamentosRepository, CondutorRepository condutorRepository) {
        this.registrosEstacionamentosRepository = registrosEstacionamentosRepository;
        this.condutorRepository = condutorRepository;
    }

    public ResponseEntity iniciarEstacionamentoFixo(EstacionamentoFixoDto estacionamentoFixoDto) {
        RegistrosEstacionamento registrosEstacionamento = new RegistrosEstacionamento(estacionamentoFixoDto);
        Optional<Condutor> condutorOptional = condutorRepository.findById(estacionamentoFixoDto.condutorId());
        if (condutorOptional.isEmpty()) {
            return ResponseEntity.badRequest().body("Condutor não encontrado");
        }
        Condutor condutor = condutorOptional.get();
        if (condutor.getTipoPagamento() != TipoPagamento.PIX && estacionamentoFixoDto.tipoServico().equals(TipoServico.FIXO)){
            return ResponseEntity.badRequest().body("Forma de pagamento PIX exclusiva para serviços de horários fixos.");
        }
        registrosEstacionamento.setCondutor(condutor);
        registrosEstacionamento.setTipoPagamento(condutor.getTipoPagamento());
        return ResponseEntity.ok(new EstacionamentoFixoDto(registrosEstacionamentosRepository.save(registrosEstacionamento)));
    }

}
