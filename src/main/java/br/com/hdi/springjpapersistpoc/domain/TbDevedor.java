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
public class TbDevedor {

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
    private Integer skDevedor;

    @Column(nullable = false, length = 6)
    private String dsTipoDocumento;

    @Column(nullable = false, length = 60)
    private String nrDocumento;

    @Column(nullable = false, length = 60)
    private String nmPessoaFisicaOuRazaoSocial;

    @Column(length = 256)
    private String dsEmail;

    @Column(nullable = false, length = 60)
    private String dsEnderecoCompleto;

    @Column(nullable = false, length = 60)
    private String nmCidade;

    @Column(nullable = false, length = 60)
    private String nmUf;

    @Column(nullable = false, length = 60)
    private String nrCep;

    @Column(nullable = false, length = 3)
    private String cdPais;

    @Column(nullable = false, length = 256)
    private String sKConsentimento;

    @Column(nullable = false)
    private Integer skRespostaAceitacaoSeguro;

    @Column(nullable = false, length = 14)
    private String nrCnpjcompanhia;

    @Column(nullable = false, length = 20)
    private String dsProdutoSeguroApi;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "apolice_id", nullable = false)
    private TbInformacaoApolice apolice;

}
