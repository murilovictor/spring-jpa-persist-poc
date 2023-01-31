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
import java.math.BigDecimal;
import java.time.LocalDate;
import lombok.Getter;
import lombok.Setter;


@Entity
@Getter
@Setter
public class TbIobjetoSeguradoEspecificoRural {

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
    private Integer flParticipaFundoEstabilidadeRural;

    @Column(precision = 20, scale = 2)
    private BigDecimal vlPremioSubvencionado;

    @Column(length = 3)
    private String cdModedaPremioSubvencionado;

    @Column(length = 2)
    private String sgUfOrigemSubvencao;

    @Column(precision = 20, scale = 2)
    private BigDecimal vlAreaSeguradaTotal;

    @Column(length = 6)
    private String dsUnidadeMedidaAreaSegurada;

    @Column(precision = 10, scale = 2)
    private BigDecimal cdCultura;

    @Column(length = 9)
    private String cdRebanho;

    @Column(length = 11)
    private String cdFloresta;

    @Column
    private LocalDate dtVistoria;

    @Column(length = 2)
    private String sgUffVistoria;

    @Column(length = 100)
    private String dsLocalVistoria;

    @Column(length = 30)
    private String nrCepVistoria;

    @Column(length = 3)
    private String cdPaisVistoria;

    @Column(length = 6)
    private String dsTipoDocumentoVistoriador;

    @Column(length = 60)
    private String nrDocumentoVistoriador;

    @Column(length = 100)
    private String nmOuRazaoSocialVistoriador;

    @Column(length = 10)
    private String dsTipoModeloParametrico;

    @Column
    private Boolean flCobreOutrosBens;

    @Column(length = 10)
    private String dsDestinacaoAnimalCoberto;

    @Column(length = 9)
    private String dsClassificacaoAnimalCoberto;

    @Column(nullable = false, length = 60)
    private String idApolice;

    @Column(nullable = false, length = 256)
    private String sKConsentimento;

    @Column(nullable = false)
    private Integer skRespostaAceitacaoSeguro;

    @Column(nullable = false, length = 14)
    private String nrCnpjcompanhia;

    @Column(nullable = false, length = 20)
    private String dsProdutoSeguroApi;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "objeto_segurado_id", nullable = false)
    private TbObjetoSegurado objetoSegurado;

}
