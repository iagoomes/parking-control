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

import java.math.BigDecimal;
import java.time.Duration;
import java.util.Optional;

import static br.com.iagoomes.fiap.parkingcontrol.model.RegistrosEstacionamento.valorPorHora;

@Service
public class ParquimetroService {
    private final RegistrosEstacionamentosRepository registrosEstacionamentosRepository;
    private final CondutorRepository condutorRepository;

    public ParquimetroService(RegistrosEstacionamentosRepository registrosEstacionamentosRepository, CondutorRepository condutorRepository) {
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

        if (registrosEstacionamento.getTipoPagamento() == null) {
            if (condutor.getTipoPagamento().equals(TipoPagamento.PIX) && registrosEstacionamento.getTipoServico() != TipoServico.FIXO) {
                return ResponseEntity.badRequest().body("A opção PIX só está disponível para períodos de estacionamento fixos");
            }
            registrosEstacionamento.setTipoPagamento(condutor.getTipoPagamento());
        } else {
            if (registrosEstacionamento.getTipoPagamento().equals(TipoPagamento.PIX) && registrosEstacionamento.getTipoServico() != TipoServico.FIXO) {
                return ResponseEntity.badRequest().body("A opção PIX só está disponível para períodos de estacionamento fixos");
            }
            registrosEstacionamento.setTipoPagamento(condutor.getTipoPagamento());
        }

        Duration duracao = Duration.between(estacionamentoFixoDto.dataInicio(), estacionamentoFixoDto.dataFim());
        registrosEstacionamento.setCondutor(condutor);
        registrosEstacionamento.setValor(valorPorHora.multiply(BigDecimal.valueOf(duracao.toHours())));

        return ResponseEntity.ok(new EstacionamentoFixoDto(registrosEstacionamentosRepository.save(registrosEstacionamento)));
    }

}
