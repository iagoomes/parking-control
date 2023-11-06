package br.com.iagoomes.fiap.parkingcontrol.model;

import br.com.iagoomes.fiap.parkingcontrol.dto.CondutorDto;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity(name = "Condutor")
@Table(name = "condutor")
public class Condutor {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SPK_Condutor")
    @SequenceGenerator(name = "SPK_Condutor", sequenceName = "SPK_Condutor_bd", allocationSize = 1)
    private Long id;
    private String nome;
    @Embedded
    private Endereco endereco;
    private String telefone;
    private String email;
    @OneToMany(mappedBy = "condutor", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Veiculo> veiculos;

    public Condutor(CondutorDto condutorDto) {
        this.nome = condutorDto.nome();
        this.endereco = new Endereco(condutorDto.enderecoDto());
        this.telefone = condutorDto.telefone();
        this.email = condutorDto.email();
    }
}
