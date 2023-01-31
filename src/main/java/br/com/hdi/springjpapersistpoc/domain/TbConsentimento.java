package br.com.hdi.springjpapersistpoc.domain;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import lombok.Getter;
import lombok.Setter;

import java.time.OffsetDateTime;
import java.util.Set;


@Entity(name = "tbconsentimento")
@Getter
@Setter
public class TbConsentimento {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tbconsentimento_skconsentimento_seq")
    @SequenceGenerator(
            name = "tbconsentimento_skconsentimento_seq",
            sequenceName = "tbconsentimento_skconsentimento_seq",
            allocationSize = 1
    )
    @Column(name = "sKConsentimento", nullable = false, updatable = false)
    private Long sKConsentimento;

    @Column(nullable = false)
    private String idConsentimento;

    @Column
    private OffsetDateTime tsInicioTransacao;

    @Column
    private OffsetDateTime tsFimTransacao;

    @Column(nullable = false)
    private OffsetDateTime tsCriacaoConsentimento;

    @Column(length = 20)
    private String dsStatus;

    @Column(nullable = false, length = 1)
    private String dsSentidoConsentimento;

    @Column
    private OffsetDateTime tsAtualizacaoStatus;

    @Column(nullable = false)
    private OffsetDateTime tsExpiracaoConsentimento;

    @Column(nullable = false)
    private OffsetDateTime tsInclusaoConsentimento;

    @Column(length = 14)
    private String nrDocumentoEmpresaSegurada;

    @Column(length = 4)
    private String cdTipoDocumentoEmpresaSegurada;

    @Column(nullable = false, length = 11)
    private String nrDocumentoPessoaFisica;

    @Column(nullable = false, length = 3)
    private String cdTipoDocumentoPessoaFisica;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idSolicitacaoConsentimento", nullable = false)
    private TbCadastroSolicitacaoConsentimento solicitacaoConsentimento;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(
            name = "tb_consentimento_tipo_consentimento",
            joinColumns = @JoinColumn(name = "sKConsentimento"),
            inverseJoinColumns = @JoinColumn(name = "skTipoConsentimento")
    )
    private Set<TbTipoConsentimento> tbConsentimentoTipoConsentimentoTbTipoConsentimentos;

    @OneToMany(mappedBy = "consentimento")
    private Set<TbContatoEmail> consentimentoTbContatoEmails;

    @OneToMany(mappedBy = "consentimento")
    private Set<TbContatoEndereco> consentimentoTbContatoEnderecos;

    @OneToMany(mappedBy = "consentimento")
    private Set<TbContatoTelefone> consentimentoTbContatoTelefones;

    @OneToMany(mappedBy = "consentimento")
    private Set<TbIdentificacaoEmpresaConcendente> consentimentoTbIdentificacaoEmpresaConcendentes;

    @OneToMany(mappedBy = "consentimento")
    private Set<TbIdentificacaoPessoaConcedente> consentimentoTbIdentificacaoPessoaConcedentes;

    @OneToMany(mappedBy = "consentimento")
    private Set<TbInformacaoComplementar> consentimentoTbInformacaoComplementars;

    @OneToMany(mappedBy = "consentimento")
    private Set<TbListaRecursos> consentimentoTbListaRecursoss;

    @OneToMany(mappedBy = "consentimento")
    private Set<TbPessoasConsentimentoEmpresa> consentimentoTbPessoasConsentimentoEmpresas;

    @OneToMany(mappedBy = "consentimento")
    private Set<TbQualificacaoEmpresaConcedente> consentimentoTbQualificacaoEmpresaConcedentes;

    @OneToMany(mappedBy = "consentimento")
    private Set<TbQualificacaoPessoaConcedente> consentimentoTbQualificacaoPessoaConcedentes;

    @OneToMany(mappedBy = "consentimento")
    private Set<TbRespostaAceitacaoSeguro> consentimentoTbRespostaAceitacaoSeguros;

}
