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
public class TbInstituicaoTransmissora {

    @Id
    @Column(nullable = false, updatable = false, length = 20)
    private String nrDocumentoInstituicaoTransmissora;

    @Column(nullable = false, length = 100)
    private String dsTipoDocumentoInstituicaoTransmissora;

    @Column(nullable = false, length = 70)
    private String nmRazaoSocialInstituicaoTransmissora;

    @Column(length = 70)
    private String nmFantasiaInstituicaoTransmissora;

    @Column(nullable = false, length = 20)
    private String dsTipoInstituicaoTransmissora;

    @OneToMany(mappedBy = "nrDocumentoInstituicaoTransmissora")
    private Set<TbCadastroSolicitacaoConsentimento> nrDocumentoInstituicaoTransmissoraTbCadastroSolicitacaoConsentimentos;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "nm_marca_transmissora_id", nullable = false)
    private TbMarcaCongenere nmMarcaTransmissora;

}
