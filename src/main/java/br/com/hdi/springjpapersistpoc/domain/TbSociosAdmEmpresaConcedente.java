package br.com.hdi.springjpapersistpoc.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import java.time.LocalDate;
import lombok.Getter;
import lombok.Setter;


@Entity
@Getter
@Setter
public class TbSociosAdmEmpresaConcedente {

    @Id
    @Column(nullable = false, updatable = false)
    @SequenceGenerator(
            name = "primary_sequence",
            sequenceName = "primary_sequence",
            allocationSize = 1,
            initialValue = 10000
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "primary_sequence"
    )
    private Integer skSocioAdmEmpresaConcedente;

    @Column(length = 13)
    private String tipoRelacaoPessoaEmpresaConcedente;

    @Column(length = 70)
    private String nmCivil;

    @Column(length = 70)
    private String nmSocial;

    @Column
    private LocalDate dtInicioParticipacao;

    @Column
    private Double pcParticipacaoSocietaria;

    @Column(length = 15)
    private String dsTipoDocumento;

    @Column(length = 20)
    private String nrDocumento;

    @Column(length = 3)
    private String cdPaisDocumento;

    @Column
    private LocalDate dtExpiracaoDocumento;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "consentimento_id", nullable = false)
    private TbIdentificacaoEmpresaConcendente consentimento;

}
