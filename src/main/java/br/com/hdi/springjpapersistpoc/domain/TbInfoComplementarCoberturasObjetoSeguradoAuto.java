package br.com.hdi.springjpapersistpoc.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import java.math.BigDecimal;
import lombok.Getter;
import lombok.Setter;


@Entity
@Getter
@Setter
public class TbInfoComplementarCoberturasObjetoSeguradoAuto {

    @Id
    @Column(nullable = false, updatable = false, length = 100)
    private String idObjetoSegurado;

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

    @Column(precision = 6, scale = 2)
    private BigDecimal pcAjusteSobreTabelaReferencia;

    @Column(precision = 20, scale = 2)
    private BigDecimal vlPremioCobertura;

    @Column(length = 3)
    private String cdMoedaPremioCobertura;

    @Column(length = 8)
    private String dsTipoIndenizacao;

    @Column(precision = 6, scale = 2)
    private BigDecimal pcIndenizacaoParcial;

    @Column(precision = 6, scale = 2)
    private BigDecimal pcSobreLmi;

    @Column
    private Integer qtDiasCoberturaDireitoIndenizacao;

    @Column(length = 8)
    private String dsCoberturaVinculada;

    @Column(nullable = false, length = 150)
    private String cdCobertura;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cd_grupo_ramo_id", nullable = false)
    private TbCoberturasObjetosSegurados cdGrupoRamo;

}
