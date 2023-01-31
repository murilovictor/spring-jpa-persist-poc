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


@Entity
@Getter
@Setter
public class TbIntermediador {

    @Id
    @Column(nullable = false, updatable = false)
    @SequenceGenerator(name = "tbintermediador_skintermediador_seq",
            sequenceName = "tbintermediador_skintermediador_seq",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "tbintermediador_skintermediador_seq"
    )
    private Integer skIntermediador;

    @Column(length = 6)
    private String dsTipoDocumento;

    @Column(length = 60)
    private String nrDocumento;

    @Column(length = 60)
    private String idapolice;

    @Column(nullable = false, length = 60)
    private String nmPessoaFisicaOuRazaoSocial;

    @Column(length = 256)
    private String dsEmail;

    @Column(length = 60)
    private String dsEnderecoCompleto;

    @Column(length = 60)
    private String nmCidade;

    @Column(length = 60)
    private String nmUf;

    @Column(length = 60)
    private String nrCep;

    @Column(length = 3)
    private String cdPais;

    @Column(length = 100)
    private String idIntermediador;

    @Column(length = 23)
    private String dsTipoIntermediador;

    @Column(nullable = false, length = 14)
    private String nrCnpjcompanhia;

    @Column(nullable = false, length = 20)
    private String dsProdutoSeguroApi;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "skinformacaoapolice", nullable = false)
    private TbInformacaoApolice informacaoApolice;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "skconsentimento", nullable = false)
    private TbConsentimento consentimento;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "skrespostaaceitacaoseguro", nullable = false)
    private TbRespostaAceitacaoSeguro respostaAceitacaoSeguro;

}
