package br.com.hdi.springjpapersistpoc.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import java.math.BigDecimal;
import java.util.Set;
import lombok.Getter;
import lombok.Setter;


@Entity
@Getter
@Setter
public class TbObjetoSegurado {

    @Id
    @Column(nullable = false, updatable = false, length = 100)
    private String idObjetoSegurado;

    @Column(nullable = false, length = 23)
    private String dsTipoObjetoSegurado;

    @Column(length = 100)
    private String dsInfoAdicionalTipoObjetoSegurado;

    @Column(nullable = false, length = 1024)
    private String dsObjetoSegurado;

    @Column(precision = 22, scale = 2)
    private BigDecimal vlObjetoSegurado;

    @Column(length = 3)
    private String cdMoeda;

    @Column(nullable = false, length = 256)
    private String sKConsentimento;

    @Column(nullable = false)
    private Integer skRespostaAceitacaoSeguro;

    @Column(nullable = false, length = 14)
    private String nrCnpjcompanhia;

    @Column(nullable = false, length = 20)
    private String dsProdutoSeguroApi;

    @OneToMany(mappedBy = "objetoSegurado")
    private Set<TbCoberturasObjetosSegurados> objetoSeguradoTbCoberturasObjetosSeguradoss;

    @OneToMany(mappedBy = "objetoSegurado")
    private Set<TbInfoComplementarObjetoSeguradoAuto> objetoSeguradoTbInfoComplementarObjetoSeguradoAutos;

    @OneToMany(mappedBy = "objetoSegurado")
    private Set<TbInformacaoEspecificaObjetoSeguradoResponsabilidade> objetoSeguradoTbInformacaoEspecificaObjetoSeguradoResponsabilidades;

    @OneToMany(mappedBy = "objetoSegurado")
    private Set<TbInformacaoEspecificaRiscoFinanceiro> objetoSeguradoTbInformacaoEspecificaRiscoFinanceiros;

    @OneToMany(mappedBy = "objetoSegurado")
    private Set<TbIobjetoSeguradoEspecificoRural> objetoSeguradoTbIobjetoSeguradoEspecificoRurals;

}
