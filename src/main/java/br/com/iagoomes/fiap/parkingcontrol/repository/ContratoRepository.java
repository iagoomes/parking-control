package br.com.iagoomes.fiap.parkingcontrol.repository;

import br.com.iagoomes.fiap.parkingcontrol.model.Contrato;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContratoRepository extends JpaRepository<Contrato, Long> {
    List<Contrato> findByCondutorIdAndAtivo(Long condutorId, boolean ativo);
}
