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
public class TbCoberturasPremio {

    @Id
    @Column(nullable = false, updatable = false, length = 256)
    private String sKConsentimento;

    @Column(nullable = false)
    private Integer skRespostaAceitacaoSeguro;

    @Column(nullable = false, length = 14)
    private String nrCnpjcompanhia;

    @Column(nullable = false)
    private Integer skInformacaoPremioApoliceSeguroFilialExterior;

    @Column(nullable = false, length = 4)
    private String cdGrupoRamo;

    @Column(nullable = false, precision = 22, scale = 2)
    private BigDecimal vlPremio;

    @Column(nullable = false, length = 3)
    private String cdMoedaPremio;

    @Column(nullable = false, length = 20)
    private String dsProdutoSeguroApi;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "apolice_id", nullable = false)
    private TbInformacaoPremioApolice apolice;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cd_cobertura_id", nullable = false)
    private TbCobertura cdCobertura;

}
