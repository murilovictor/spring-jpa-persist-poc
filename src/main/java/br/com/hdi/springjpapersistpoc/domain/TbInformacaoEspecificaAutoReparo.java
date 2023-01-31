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
public class TbInformacaoEspecificaAutoReparo {

    @Id
    @Column(nullable = false, updatable = false, length = 256)
    private String sKConsentimento;

    @Column(nullable = false)
    private Integer skRespostaAceitacaoSeguro;

    @Column(nullable = false, length = 14)
    private String nrCnpjcompanhia;

    @Column(nullable = false, length = 20)
    private String dsProdutoSeguroApi;

    @Column(nullable = false, length = 17)
    private String dsRedeReparacao;

    @Column(nullable = false, length = 12)
    private String dsTipoPecasReparacao;

    @Column(nullable = false, length = 21)
    private String dsClassificacaoPecasReparacao;

    @Column(length = 20)
    private String dsNacionalidadePecasReparacao;

    @Column(nullable = false, length = 23)
    private String dsTipoVigencia;

    @Column(length = 500)
    private String dsOutrasRecompensas;

    @Column(length = 19)
    private String dsBeneficiosAdicionais;

    @Column(length = 23)
    private String dsPacoteAssistencia;

    @Column
    private Boolean flApoliceRiscoDecorrido;

    @Column(precision = 20, scale = 2)
    private BigDecimal pcDescontoBonus;

    @Column(length = 500)
    private String dsClasseBonus;

    @OneToMany(mappedBy = "apolice")
    private Set<TbCondutor> apoliceTbCondutors;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "apolice_id", nullable = false)
    private TbInformacaoApolice apolice;

}
