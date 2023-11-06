package br.com.iagoomes.fiap.parkingcontrol.repository;

import br.com.iagoomes.fiap.parkingcontrol.model.Veiculo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VeiculoRepository extends JpaRepository<Veiculo, Long> {
}
