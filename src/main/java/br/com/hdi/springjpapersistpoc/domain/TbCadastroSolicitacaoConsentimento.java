package br.com.hdi.springjpapersistpoc.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import java.time.OffsetDateTime;
import java.util.Set;
import lombok.Getter;
import lombok.Setter;


@Entity
@Getter
@Setter
public class TbCadastroSolicitacaoConsentimento {

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
    private Integer idSolicitacaoConsentimento;

    @Column
    private OffsetDateTime tsInicioTransacao;

    @Column
    private OffsetDateTime tsFimTransacao;

    @Column(nullable = false)
    private OffsetDateTime tsCriacaoConsentimento;

    @Column(nullable = false, length = 1)
    private String dsSentidoConsentimento;

    @Column(nullable = false)
    private OffsetDateTime tsExpiracaoConsentimento;

    @Column(length = 14)
    private String nrDocumentoEmpresaSegurada;

    @Column(length = 4)
    private String cdTipoDocumentoEmpresaSegurada;

    @Column(nullable = false, length = 11)
    private String nrDocumentoPessoaFisica;

    @Column(nullable = false, length = 3)
    private String cdTipoDocumentoPessoaFisica;

    @Column(nullable = false, length = 100)
    private String dsTipoDocumentoInstituicaoTransmissora;

    @Column(columnDefinition = "text")
    private String idToken;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "nr_documento_instituicao_transmissora_id", nullable = false)
    private TbInstituicaoTransmissora nrDocumentoInstituicaoTransmissora;

    @OneToMany(mappedBy = "solicitacaoConsentimento")
    private Set<TbConsentimento> solicitacaoConsentimentoTbConsentimentos;

    @OneToMany(mappedBy = "solicitacaoConsentimento")
    private Set<TbFilaCosultasApienviadas> solicitacaoConsentimentoTbFilaCosultasApienviadass;

    @OneToMany(mappedBy = "solicitacaoConsentimento")
    private Set<TbPreCadastro> solicitacaoConsentimentoTbPreCadastros;

    @ManyToMany(mappedBy = "tbProdutoSolicitadoTbCadastroSolicitacaoConsentimentos")
    private Set<TbProdutoHdi> tbProdutoSolicitadoTbProdutoHdis;

}
