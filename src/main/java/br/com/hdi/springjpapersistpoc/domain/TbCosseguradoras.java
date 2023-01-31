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

import java.math.BigDecimal;


@Entity
@Getter
@Setter
public class TbCosseguradoras {

    @Id
    @Column(nullable = false, updatable = false)
    @SequenceGenerator(
            name = "tbcosseguradoras_skcosseguradora_seq",
            sequenceName = "tbcosseguradoras_skcosseguradora_seq",
            allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "tbcosseguradoras_skcosseguradora_seq")
    private Long skCosseguradora;

    @Column(nullable = false, length = 60)
    private String idCosseguradora;

    @Column(nullable = false, length = 60)
    private String idApolice;

    @Column(nullable = false, precision = 21, scale = 9)
    private BigDecimal pcCedidoCosseguradora;

    @Column(nullable = false, length = 14)
    private String nrCnpjcompanhia;

    @Column(nullable = false, length = 20)
    private String dsProdutoSeguroApi;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "skrespostaaceitacaoseguro", nullable = false)
    private TbRespostaAceitacaoSeguro skRespostaAceitacaoSeguro;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "skconsentimento", nullable = false)
    private TbConsentimento consentimento;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "skinformacaoapolice", nullable = false)
    private TbInformacaoApolice informacaoApolice;



}
