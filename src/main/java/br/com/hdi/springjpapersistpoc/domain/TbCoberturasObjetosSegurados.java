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
public class TbCoberturasObjetosSegurados {

    @Id
    @Column(nullable = false, updatable = false, length = 4)
    private String cdGrupoRamo;

    @Column(nullable = false, length = 26)
    private String dsTipoCobertura;

    @Column(nullable = false, precision = 22, scale = 2)
    private BigDecimal vlLmi;

    @Column(nullable = false, length = 3)
    private String cdMoedaLmi;

    @Column(nullable = false)
    private Integer vlPeriodoCarencia;

    @Column(nullable = false, length = 3)
    private String dsPeriodicidadeCarencia;

    @Column(length = 13)
    private String dsMetodoContagemPrazoCarencia;

    @Column(nullable = false)
    private LocalDate dtInicioVigenciaCobertura;

    @Column(nullable = false)
    private LocalDate dtFimVigenciaCobertura;

    @Column(nullable = false)
    private LocalDate dtInicioCarencia;

    @Column(nullable = false)
    private LocalDate dtFimCarencia;

    @Column(nullable = false, length = 60)
    private String idApolice;

    @Column(nullable = false, length = 256)
    private String sKConsentimento;

    @Column(nullable = false)
    private Integer skRespostaAceitacaoSeguro;

    @Column(nullable = false, length = 14)
    private String nrCnpjcompanhia;

    @Column(length = 500)
    private String cdInternoCobertura;

    @Column(nullable = false, length = 50)
    private String nrProcessoSusep;

    @Column
    private Boolean flLmisublimite;

    @Column
    private Boolean flCoberturaPrincipal;

    @Column(nullable = false, length = 25)
    private String dsCaracteristicaCobertura;

    @Column(nullable = false, length = 20)
    private String dsProdutoSeguroApi;

    @Column(length = 500)
    private String dsCobertura;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "objeto_segurado_id", nullable = false)
    private TbObjetoSegurado objetoSegurado;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cd_cobertura_id", nullable = false)
    private TbCobertura cdCobertura;

    @OneToMany(mappedBy = "cdGrupoRamo")
    private Set<TbInfoComplementarCoberturasObjetoSeguradoAuto> cdGrupoRamoTbInfoComplementarCoberturasObjetoSeguradoAutos;

}
