package br.com.iagoomes.fiap.parkingcontrol.repository;

import br.com.iagoomes.fiap.parkingcontrol.model.RegistrosEstacionamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RegistrosEstacionamentosRepository extends JpaRepository<RegistrosEstacionamento, Long> {
    @Query(value = """
            SELECT RE.*
            FROM REGISTROS_ESTACIONAMENTO RE, CONDUTOR C
            WHERE RE.CONDUTOR_ID = C.ID
            AND RE.TIPO_SERVICO = 'FIXO'
            AND SYSTIMESTAMP - RE.DATA_INICIO <= INTERVAL '15' MINUTE
            """, nativeQuery = true)
    List<RegistrosEstacionamento> buscarFixosQuaseEncerrados();
}
