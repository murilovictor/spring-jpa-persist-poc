package br.com.hdi.springjpapersistpoc.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;


@Entity
@Getter
@Setter
public class TbListaAtributos {

    @Id
    @Column(nullable = false, updatable = false, length = 100)
    private String nmColuna;

    @Column(nullable = false, length = 100)
    private String nmEsquemaTabela;

    @Column(nullable = false, length = 100)
    private String nmTabela;

    @Column(nullable = false)
    private Boolean flAtributoVisivel;

    @Column(nullable = false, length = 100)
    private String dsAtributo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "sk_tipo_consentimento_id", nullable = false)
    private TbTabelasDadosTipoConsentimento skTipoConsentimento;

}
