package br.com.iagoomes.fiap.parkingcontrol.repository;

import br.com.iagoomes.fiap.parkingcontrol.model.Condutor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CondutorRepository extends JpaRepository<Condutor, Long> {
}
