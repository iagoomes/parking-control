package br.com.iagoomes.fiap.parkingcontrol.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
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
    private int ano;
    private String placa;
    @ManyToOne
    @JoinColumn(name = "condutor_id")
    private Condutor condutor;
}
