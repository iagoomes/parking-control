package br.com.iagoomes.fiap.parkingcontrol.service;

import br.com.iagoomes.fiap.parkingcontrol.dto.*;
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
import java.time.LocalDateTime;
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
        RegistrosEstacionamento estacionamento = new RegistrosEstacionamento(estacionamentoFixoDto);
        Optional<Condutor> condutorOptional = condutorRepository.findById(estacionamentoFixoDto.getCondutorId());

        if (condutorOptional.isEmpty()) {
            return ResponseEntity.badRequest().body("Condutor não encontrado");
        }

        Condutor condutor = condutorOptional.get();

        TipoPagamento tipoPagamento = estacionamento.getTipoPagamento();

        if (tipoPagamento == null) {
            tipoPagamento = condutor.getTipoPagamento();
        }

        if (tipoPagamento.equals(TipoPagamento.PIX) && estacionamento.getTipoServico() != TipoServico.FIXO) {
            return ResponseEntity.badRequest().body("A opção PIX só está disponível para períodos de estacionamento fixos");
        }

        estacionamento.setTipoPagamento(tipoPagamento);
        estacionamento.setCondutor(condutor);
        estacionamento.setStatus(Boolean.TRUE);

        return ResponseEntity.ok(new EstacionamentoResponseDto(registrosEstacionamentosRepository.save(estacionamento)));
    }

    public ResponseEntity iniciarEstacionamentoPorHora(EstacionamentoPorHoraDto estacionamentoPorHoraDto) {
        RegistrosEstacionamento estacionamento = new RegistrosEstacionamento(estacionamentoPorHoraDto);
        Optional<Condutor> condutorOptional = condutorRepository.findById(estacionamentoPorHoraDto.getCondutorId());
        if (condutorOptional.isEmpty()) {
            return ResponseEntity.badRequest().body("Condutor não encontrado");
        }
        Condutor condutor = condutorOptional.get();

        TipoPagamento tipoPagamento = estacionamento.getTipoPagamento();
        if (tipoPagamento == null) {
            tipoPagamento = condutor.getTipoPagamento();
        }
        if (tipoPagamento.equals(TipoPagamento.PIX) && estacionamento.getTipoServico() != TipoServico.FIXO) {
            return ResponseEntity.badRequest().body("A opção PIX só está disponível para períodos de estacionamento fixos");
        }
        estacionamento.setTipoPagamento(tipoPagamento);
        estacionamento.setCondutor(condutor);
        estacionamento.setStatus(Boolean.TRUE);

        return ResponseEntity.ok(new EstacionamentoResponseDto(registrosEstacionamentosRepository.save(estacionamento)));
    }

    public ResponseEntity encerrarEstacionamento(Long registroId) {
        Optional<RegistrosEstacionamento> estacionamentoOptional = registrosEstacionamentosRepository.findById(registroId);
        if (estacionamentoOptional.isEmpty()) {
            return ResponseEntity.badRequest().body("Registro de estacionamento não encontrado");
        }
        RegistrosEstacionamento estacionamento = estacionamentoOptional.get();

        if (estacionamento.getDataFim() == null) {
            estacionamento.setValor(calcularValor(estacionamento.getDataInicio(), LocalDateTime.now()));
        } else {
            estacionamento.setValor(calcularValor(estacionamento.getDataInicio(), estacionamento.getDataFim()));
        }
        estacionamento.setStatus(Boolean.FALSE);
        registrosEstacionamentosRepository.save(estacionamento);
        return ResponseEntity.ok(new EstacionamentoPagoResponseDto(estacionamento));
    }

    public BigDecimal calcularValor(LocalDateTime dataInicio, LocalDateTime dataFim) {
        Duration duracao = Duration.between(dataInicio, dataFim);
        long hours = Math.max(1, (long) Math.ceil(duracao.toMinutes() / 60.0));
        return valorPorHora.multiply(BigDecimal.valueOf(hours));
    }

}
