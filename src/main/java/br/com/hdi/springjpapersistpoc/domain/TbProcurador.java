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
import lombok.Getter;
import lombok.Setter;


@Entity
@Getter
@Setter
public class TbProcurador {

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
    private Integer skProdutoServico;

    @Column(nullable = false)
    private Integer procuratorId;

    @Column(nullable = false, length = 19)
    private String dsNaturezaPoderProcurador;

    @Column(length = 11)
    private String nrCpf;

    @Column(length = 70)
    private String nmSocial;

    @Column(length = 70)
    private String nmCivil;

    @Column(nullable = false, length = 256)
    private String sKConsentimento;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "sk_informacao_complementar_id", nullable = false)
    private TbProdutoServico skInformacaoComplementar;

}
