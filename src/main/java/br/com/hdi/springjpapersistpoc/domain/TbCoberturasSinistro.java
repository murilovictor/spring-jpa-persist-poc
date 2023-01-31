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
public class TbCoberturasSinistro {

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
    private Integer skCoberturasSinistro;

    @Column(length = 100)
    private String idObjetoSegurado;

    @Column(nullable = false, length = 4)
    private String cdGrupoRamo;

    @Column(length = 500)
    private String dsCobertura;

    @Column
    private LocalDate dtAvisoSinistro;

    @Column
    private LocalDate dtReclamacaoTerceiro;

    @Column(nullable = false, length = 256)
    private String sKConsentimento;

    @Column(nullable = false)
    private Integer skRespostaAceitacaoSeguro;

    @Column(nullable = false, length = 14)
    private String nrCnpjcompanhia;

    @Column(nullable = false, length = 50)
    private String idProcessoSinistro;

    @Column(nullable = false, length = 20)
    private String dsProdutoSeguroApi;

    @Column(nullable = false, length = 150)
    private String cdCobertura;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "apolice_id", nullable = false)
    private TbInformacaoSinistroApolice apolice;

}
