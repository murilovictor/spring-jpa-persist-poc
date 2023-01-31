package br.com.hdi.springjpapersistpoc.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import java.time.LocalDate;
import lombok.Getter;
import lombok.Setter;


@Entity
@Getter
@Setter
public class TbPreCadastro {

    @Id
    @Column(nullable = false, updatable = false, length = 15)
    private String dsTipoDocumentoPessoa;

    @Column(nullable = false, length = 20)
    private String nrDocumentoPessoa;

    @Column(length = 70)
    private String nmCivilPessoa;

    @Column(length = 3)
    private String cdPaisDocumentoPessoa;

    @Column
    private LocalDate dtExpiracaoDocumentoPessoa;

    @Column(length = 20)
    private String dsEmailPessoa;

    @Column(nullable = false, length = 100)
    private String dsTipoDocumentoEmpresa;

    @Column(nullable = false, length = 20)
    private String nrDocumentoEmpresa;

    @Column(length = 3)
    private String cdPaisEmissorDocumento;

    @Column
    private LocalDate dtExpiracaoDocumento;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "solicitacao_consentimento_id", nullable = false)
    private TbCadastroSolicitacaoConsentimento solicitacaoConsentimento;

}
