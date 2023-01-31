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
public class TbPagamentosPremio {

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
    private Long id;

    @Column(nullable = false)
    private LocalDate dtMovimentoPremio;

    @Column(nullable = false, length = 35)
    private String dsTipoMovimento;

    @Column(length = 27)
    private String dsOrigemMovimento;

    @Column(nullable = false)
    private Integer nrParcelaPremio;

    @Column(nullable = false, length = 256)
    private String sKConsentimento;

    @Column(nullable = false)
    private Integer skRespostaAceitacaoSeguro;

    @Column(nullable = false, length = 14)
    private String nrCnpjcompanhia;

    @Column(nullable = false)
    private Integer skInformacaoPremioApoliceSeguroFilialExterior;

    @Column(nullable = false, precision = 22, scale = 2)
    private BigDecimal vlParcelaPremio;

    @Column(nullable = false, length = 3)
    private String cdMoedaParcela;

    @Column(nullable = false)
    private LocalDate dtVencimentoParcela;

    @Column(length = 1024)
    private String dsDocumentoPagadorRecebedor;

    @Column(length = 6)
    private String dsTipoDocumentoPagadorRecebedor;

    @Column(length = 100)
    private String nmPessoaFisicaOuRazaoSocialPagadorRecebedor;

    @Column(length = 100)
    private String cdInstituicaoFinanceiraPagamento;

    @Column(length = 19)
    private String dsTipoPagamento;

    @Column(nullable = false, length = 20)
    private String dsProdutoSeguroApi;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "apolice_id", nullable = false)
    private TbInformacaoPremioApolice apolice;

}
