package br.com.hdi.springjpapersistpoc.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import java.time.LocalDate;
import lombok.Getter;
import lombok.Setter;


@Entity
@Getter
@Setter
public class TbInformacaoEspecificaCoberturaResponsabilidade {

    @Id
    @Column(nullable = false, updatable = false, length = 500)
    private String dsCobertura;

    @Column(length = 14)
    private String dsBaseIndenizacao;

    @Column(length = 500)
    private String dsBaseIndenizacaoComplementar;

    @Column
    private LocalDate dtLimiteRetroatividade;

    @Column(length = 100)
    private String dsPrazoRetroatividade;

    @Column(length = 3)
    private String dsUnidadeTempoRetroatividade;

    @Column(length = 13)
    private String dsIndicadorDiasUteisRetroatividade;

    @Column
    private LocalDate dtInicioPrazoAdicionalComplementar;

    @Column
    private LocalDate dtFimPrazoAdicionalComplementar;

    @Column(length = 100)
    private String dsPrazoAdicionalComplementar;

    @Column(length = 3)
    private String dsUnidadePrazoAdicionalComplementar;

    @Column(length = 13)
    private String dsIndicadorDiasUteisPrazoAdicionalComplementar;

    @Column
    private LocalDate dtInicioPrazoAdicionalSuplementar;

    @Column
    private LocalDate dtFimPrazoAdicionalSuplementar;

    @Column(length = 100)
    private String dsPrazoAdicionalSuplementar;

    @Column(length = 3)
    private String dsUnidadePrazoAdicionalSuplementar;

    @Column(length = 13)
    private String dsIndicadorDiasUteisPrazoAdicionalSuplementar;

    @Column(length = 23)
    private String dsIndicacaoAdvogado;

    @Column(length = 500)
    private String dsFormaIndicacaoAdvogado;

    @Column(nullable = false, length = 256)
    private String sKConsentimento;

    @Column(nullable = false)
    private Integer skRespostaAceitacaoSeguro;

    @Column(nullable = false, length = 14)
    private String nrCnpjcompanhia;

    @Column(nullable = false, length = 4)
    private String cdGrupoRamo;

    @Column(nullable = false, length = 20)
    private String dsProdutoSeguroApi;

    @Column(nullable = false, length = 150)
    private String cdCobertura;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "apolice_id", nullable = false)
    private TbCoberturaApolice apolice;

}
