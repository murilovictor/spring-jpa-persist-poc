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
public class TbCoberturaApolice {

    @Id
    @Column(nullable = false, updatable = false, length = 4)
    private String cdGrupoRamo;

    @Column(nullable = false, length = 9)
    private String dsTipoFranquia;

    @Column(length = 500)
    private String dsInfoAdicionalTipoFranquia;

    @Column(nullable = false, precision = 12, scale = 2)
    private BigDecimal vlFranquia;

    @Column(nullable = false, length = 3)
    private String cdMoedaFranquia;

    @Column(nullable = false)
    private Integer vlPrazoFranquia;

    @Column(nullable = false, length = 3)
    private String dsPeriodicidadeFranquia;

    @Column(length = 13)
    private String dsMetodoContagemPrazoFranquia;

    @Column(nullable = false)
    private LocalDate dtInicioContagemFranquia;

    @Column(nullable = false)
    private LocalDate dtFimContagemFranquia;

    @Column(nullable = false, length = 60)
    private String dsFranquia;

    @Column(nullable = false, length = 256)
    private String sKConsentimento;

    @Column(nullable = false)
    private Integer skRespostaAceitacaoSeguro;

    @Column(nullable = false, length = 14)
    private String nrCnpjcompanhia;

    @Column(nullable = false, length = 10)
    private String dsFormaAplicacaoPos;

    @Column(nullable = false, length = 60)
    private String dsPos;

    @Column(precision = 20, scale = 2)
    private BigDecimal vlMinPos;

    @Column(length = 3)
    private String cdMoedaMinPos;

    @Column(precision = 20, scale = 2)
    private BigDecimal vlMaxPos;

    @Column(length = 3)
    private String cdMoedaMaxPos;

    @Column(precision = 21, scale = 9)
    private BigDecimal pcPos;

    @Column(nullable = false, length = 20)
    private String dsProdutoSeguroApi;

    @Column
    private Boolean flFranquiaSobreIndenizacaoIntegral;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "apolice_id", nullable = false)
    private TbInformacaoApolice apolice;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cd_cobertura_id", nullable = false)
    private TbCobertura cdCobertura;

    @OneToMany(mappedBy = "apolice")
    private Set<TbInformacaoEspecificaCoberturaResponsabilidade> apoliceTbInformacaoEspecificaCoberturaResponsabilidades;

}
