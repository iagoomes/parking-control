package br.com.iagoomes.fiap.parkingcontrol.service;

import br.com.iagoomes.fiap.parkingcontrol.model.RegistrosEstacionamento;
import br.com.iagoomes.fiap.parkingcontrol.repository.RegistrosEstacionamentosRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Log4j2
public class TemporizadorService {

    private final RegistrosEstacionamentosRepository registrosEstacionamentosRepository;

    public TemporizadorService(RegistrosEstacionamentosRepository registrosEstacionamentosRepository) {
        this.registrosEstacionamentosRepository = registrosEstacionamentosRepository;
    }

    @Scheduled(fixedRate = 900000) // Executa a cada 15 minutos (900.000 milissegundos)
    public void verificarTempoEstacionamentoFixo() {
        List<RegistrosEstacionamento> estacionamentos = registrosEstacionamentosRepository.buscarFixosQuaseEncerrados();
        for (RegistrosEstacionamento re :
                estacionamentos) {
            log.info("Senhor " + re.getCondutor().getNome() + " o periodo do seu estacionamento está preste a encerrar.");
        }
    }

    @Scheduled(fixedRate = 900000)
    public void verificarTempoEstacionamentoPorHora() {
        List<RegistrosEstacionamento> estacionamentos = registrosEstacionamentosRepository.buscarFixosQuaseEncerrados();
        for (RegistrosEstacionamento re :
                estacionamentos) {
            log.info("Senhor " + re.getCondutor().getNome() + " em 15 minutos o periodo do seu estacionamento vai ser prorrogado por mais 1 hora.");
        }
    }

    // Método chamado quando o motorista desliga o registro
    public void desligarRegistro() {
        // Lógica para desligar o registro quando o motorista deseja interromper a extensão automática.
    }

    // Método chamado quando há um acionamento para estacionar
    public void iniciarEstacionamento() {
        // Lógica para iniciar a contabilização do tempo de estacionamento e demais operações.
    }

    // Outros métodos conforme necessário
}
