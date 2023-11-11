package br.com.iagoomes.fiap.parkingcontrol.model;

import br.com.iagoomes.fiap.parkingcontrol.dto.CondutorDto;
import com.fasterxml.jackson.annotation.JsonIgnore;
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

    @Column(name = "nome")
    private String nome;

    @Column(name = "cpf")
    private String cpf;

    @Embedded
    private Endereco endereco;

    @Column(name = "telefone")
    private String telefone;

    @Column(name = "email")
    private String email;

    @OneToMany(mappedBy = "condutor", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Veiculo> veiculos;

    @OneToMany(mappedBy = "condutor")
    @JsonIgnore
    private List<Contrato> contrato;

    public Condutor(CondutorDto condutorDto) {
        this.nome = condutorDto.nome();
        this.cpf = condutorDto.cpf();
        this.endereco = new Endereco(condutorDto.enderecoDto());
        this.telefone = condutorDto.telefone();
        this.email = condutorDto.email();
    }
}
