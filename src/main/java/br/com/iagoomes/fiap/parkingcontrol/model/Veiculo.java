package br.com.iagoomes.fiap.parkingcontrol.model;

import br.com.iagoomes.fiap.parkingcontrol.dto.VeiculoDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity(name = "Veiculo")
@Table(name = "veiculo")
public class Veiculo {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SPK_Veiculo")
    @SequenceGenerator(name = "SPK_Veiculo", sequenceName = "SPK_Veiculo_bd", allocationSize = 1)
    private Long id;
    private String marca;
    private String modelo;
    private String cor;
    private int ano;
    private String placa;
    @ManyToOne
    @JoinColumn(name = "condutor_id")
    private Condutor condutor;

    public Veiculo(VeiculoDto veiculoDto) {
        this.marca = veiculoDto.marca();
        this.modelo = veiculoDto.modelo();
        this.cor = veiculoDto.cor();
        this.ano = veiculoDto.ano();
        this.placa = veiculoDto.placa();
    }
}
