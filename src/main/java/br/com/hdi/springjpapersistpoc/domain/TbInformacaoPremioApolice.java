package br.com.hdi.springjpapersistpoc.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import java.math.BigDecimal;
import java.util.Set;
import lombok.Getter;
import lombok.Setter;


@Entity
@Getter
@Setter
public class TbInformacaoPremioApolice {

    @Id
    @Column(nullable = false, updatable = false, length = 256)
    private String sKConsentimento;

    @Column(nullable = false)
    private Integer skRespostaAceitacaoSeguro;

    @Column(nullable = false, length = 14)
    private String nrCnpjcompanhia;

    @Column(nullable = false, length = 18)
    private String qtPagamentos;

    @Column(nullable = false, precision = 22, scale = 2)
    private BigDecimal vlTotalPremioContrato;

    @Column(nullable = false, length = 3)
    private String cdMoedaTotalPremio;

    @Column(nullable = false)
    private Integer skInformacaoPremioApoliceSeguroFilialExterior;

    @Column(nullable = false, length = 20)
    private String dsProdutoSeguroApi;

    @OneToMany(mappedBy = "apolice")
    private Set<TbCoberturasPremio> apoliceTbCoberturasPremios;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "apolice_id", nullable = false)
    private TbInformacaoApolice apolice;

    @OneToMany(mappedBy = "apolice")
    private Set<TbPagamentosPremio> apoliceTbPagamentosPremios;

}
