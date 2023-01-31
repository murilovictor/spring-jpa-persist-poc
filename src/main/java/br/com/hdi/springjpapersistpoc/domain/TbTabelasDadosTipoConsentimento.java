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
public class TbTabelasDadosTipoConsentimento {

    @Id
    @Column(nullable = false, updatable = false, length = 100)
    private String nmTabela;

    @Column(nullable = false, length = 100)
    private String nmEsquemaTabela;

    @OneToMany(mappedBy = "skTipoConsentimento")
    private Set<TbListaAtributos> skTipoConsentimentoTbListaAtributoss;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "sk_tipo_consentimento_id", nullable = false)
    private TbTipoConsentimento skTipoConsentimento;

}
