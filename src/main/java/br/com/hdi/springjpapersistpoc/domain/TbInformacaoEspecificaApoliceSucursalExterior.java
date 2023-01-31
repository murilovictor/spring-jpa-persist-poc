package br.com.hdi.springjpapersistpoc.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import java.util.Set;
import lombok.Getter;
import lombok.Setter;


@Entity
@Getter
@Setter
public class TbInformacaoEspecificaApoliceSucursalExterior {

    @Id
    @Column(nullable = false, updatable = false, length = 3)
    private String cdPaisOrigemRiscoEmitido;

    @Column(nullable = false)
    private Boolean flPossuiForumArbitragem;

    @Column(length = 500)
    private String dsForum;

    @Column(nullable = false, length = 40)
    private String idDocumentoCedenteRisco;

    @Column(nullable = false, length = 256)
    private String sKConsentimento;

    @Column(nullable = false)
    private Integer skRespostaAceitacaoSeguro;

    @Column(nullable = false, length = 14)
    private String nrCnpjcompanhia;

    @Column(nullable = false, length = 20)
    private String dsProdutoSeguroApi;

    @Column(nullable = false, length = 500)
    private String nmPessoaOuRazaoSocialCedenteRisco;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "apolice_id", nullable = false)
    private TbInformacaoApolice apolice;

    @OneToMany(mappedBy = "apolice")
    private Set<TbInformacaoEspecificaRamoApoliceSucursalExterior> apoliceTbInformacaoEspecificaRamoApoliceSucursalExteriors;

}
