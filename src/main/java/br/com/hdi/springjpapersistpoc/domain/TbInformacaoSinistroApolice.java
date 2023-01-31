package br.com.hdi.springjpapersistpoc.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Set;
import lombok.Getter;
import lombok.Setter;


@Entity
@Getter
@Setter
public class TbInformacaoSinistroApolice {

    @Id
    @Column(nullable = false, updatable = false, length = 256)
    private String sKConsentimento;

    @Column(nullable = false)
    private Integer skRespostaAceitacaoSeguro;

    @Column(nullable = false, length = 14)
    private String nrCnpjcompanhia;

    @Column(nullable = false, length = 50)
    private String idProcessoSinistro;

    @Column(nullable = false)
    private LocalDate dtEntregaDocumentacaoCompleta;

    @Column(nullable = false, length = 30)
    private String dsStatusSinistro;

    @Column(nullable = false)
    private LocalDate dtAtualizacaoStatusSinistro;

    @Column(nullable = false)
    private LocalDate dtOcorrenciaSinistro;

    @Column
    private LocalDate dtAvisoSinistro;

    @Column
    private LocalDate dtReclamacaoTerceiro;

    @Column(nullable = false, precision = 22, scale = 2)
    private BigDecimal vlSinistro;

    @Column(nullable = false, length = 3)
    private String cdMoedaSinistro;

    @Column(length = 23)
    private String dsJustificativaNegativa;

    @Column(length = 100)
    private String dsOutrasJustificativasNegativa;

    @Column(nullable = false, length = 20)
    private String dsProdutoSeguroApi;

    @OneToMany(mappedBy = "apolice")
    private Set<TbCoberturasSinistro> apoliceTbCoberturasSinistros;

    @OneToMany(mappedBy = "apolice")
    private Set<TbInformacaoAnexoEspecificoSinistroAuto> apoliceTbInformacaoAnexoEspecificoSinistroAutos;

    @OneToMany(mappedBy = "apolice")
    private Set<TbInformacaoAnexoEspecificoSinistroRural> apoliceTbInformacaoAnexoEspecificoSinistroRurals;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "apolice_id", nullable = false)
    private TbInformacaoApolice apolice;

}
