package br.com.hdi.springjpapersistpoc.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.util.Set;
import lombok.Getter;
import lombok.Setter;


@Entity
@Getter
@Setter
public class TbIdentificacaoPessoaConcedente {

    @Id
    @Column(nullable = false, updatable = false, length = 100)
    private String idPessoaConcedente;

    @Column(nullable = false, length = 80)
    private String nmMarcaCongenere;

    @Column(nullable = false, length = 14)
    private String nrCnpjcongenere;

    @Column(nullable = false, length = 70)
    private String nmCompanhiaCongenere;

    @Column(nullable = false)
    private OffsetDateTime dtAtualizcao;

    @Column(length = 70)
    private String nmSocial;

    @Column(length = 11)
    private String nrCpf;

    @Column(nullable = false, length = 70)
    private String nmCivil;

    @Column
    private Boolean flNacionalidadeBrasileira;

    @Column(length = 3)
    private String cdPaisNacionalidadeEstrangeira;

    @Column(length = 20)
    private String dsSexo;

    @Column
    private LocalDate dtNascimento;

    @Column(length = 22)
    private String dsEstadoCivil;

    @Column(length = 3)
    private String dsAncestralFiliacao;

    @Column(length = 70)
    private String nmCivilAncestralFiliacao;

    @Column(length = 70)
    private String nmCivilConjuge;

    @Column(length = 11)
    private String nrCpfconjuge;

    @Column(length = 40)
    private String tpDocumentoEstrangeiro;

    @Column(length = 20)
    private String nrDocumentoEstrangeiro;

    @Column(length = 40)
    private String cdPaisDocumentoEstrangeiro;

    @Column
    private LocalDate dtExpiracaoDocumentoEstrangeiro;

    @OneToMany(mappedBy = "consentimento")
    private Set<TbDocumentoPessoal> consentimentoTbDocumentoPessoals;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "consentimento_id", nullable = false)
    private TbConsentimento consentimento;

}
