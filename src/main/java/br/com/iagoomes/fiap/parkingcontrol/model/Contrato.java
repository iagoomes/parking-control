package br.com.iagoomes.fiap.parkingcontrol.model;

import br.com.iagoomes.fiap.parkingcontrol.dto.CadastroContratoDto;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@Entity(name = "Contrato")
@Table(name = "contrato")
public class    Contrato {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SPK_Contrato")
    @SequenceGenerator(name = "SPK_Contrato", sequenceName = "SPK_Contrato_bd", allocationSize = 1)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_contrato")
    private TipoContrato tipoContrato;

    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_pagamento")
    private TipoPagamento tipoPagamento;

    @ManyToOne
    private Condutor condutor;

    @Column(name = "ativo")
    private Boolean ativo;

    public Contrato(CadastroContratoDto cadastroContratoDto) {
        this.tipoContrato = cadastroContratoDto.contrato().tipoContrato();
        this.tipoPagamento = cadastroContratoDto.contrato().tipoPagamento();
        this.ativo = true;
    }
}
