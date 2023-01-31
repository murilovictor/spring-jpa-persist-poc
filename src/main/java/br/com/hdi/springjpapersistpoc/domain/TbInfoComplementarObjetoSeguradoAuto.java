package br.com.hdi.springjpapersistpoc.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;


@Entity
@Getter
@Setter
public class TbInfoComplementarObjetoSeguradoAuto {

    @Id
    @Column(nullable = false, updatable = false, length = 60)
    private String idApolice;

    @Column(nullable = false, length = 256)
    private String sKConsentimento;

    @Column(nullable = false)
    private Integer skRespostaAceitacaoSeguro;

    @Column(nullable = false, length = 14)
    private String nrCnpjcompanhia;

    @Column(nullable = false, length = 20)
    private String dsProdutoSeguroApi;

    @Column
    private Boolean flIdentificacaoExataVeiculo;

    @Column(length = 29)
    private String dsModalidadeCobertura;

    @Column(length = 15)
    private String dsTabelaReferenciaValorCobertura;

    @Column(length = 8)
    private String cdModeloAuto;

    @Column(length = 4)
    private String nrAnoModeloAuto;

    @Column(length = 3)
    private String cdCategoriaTarifaria;

    @Column(length = 60)
    private String nrCepRisco;

    @Column(length = 21)
    private String cdUtilizacaoVeiculo;

    @Column(length = 60)
    private String nrCepLocalidadeDestinoFrequente;

    @Column(length = 60)
    private String nrCeplocalidadePernoite;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "objeto_segurado_id", nullable = false)
    private TbObjetoSegurado objetoSegurado;

}
