package br.com.iagoomes.fiap.parkingcontrol.repository;

import br.com.iagoomes.fiap.parkingcontrol.model.Condutor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CondutorRepository extends JpaRepository<Condutor, Long> {
    @Query(value = """
            SELECT COUNT(1)
            FROM condutor c
            WHERE c.cpf = :cpf""", nativeQuery = true)
    Integer findByCpf(@Param("cpf") String cpf);

    @Query(value = """
            SELECT COUNT(1)
            FROM condutor,
                 contrato
            WHERE condutor.ID = contrato.ID
            AND   contrato.CONDUTOR_ID = :id
            AND   contrato.ATIVO = 1""", nativeQuery = true)
    Integer existeContratoAtivo(Long id);
}
