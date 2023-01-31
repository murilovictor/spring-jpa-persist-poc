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
public class TbProdutoServico {

    @Id
    @Column(nullable = false, updatable = false, length = 17)
    private String nrContratoApolice;

    @Column(nullable = false)
    private Integer skProdutoServico;

    @Column(nullable = false, length = 40)
    private String dsTipoContratoApolice;

    @Column(length = 4)
    private String cdGrupoRamo;

    @Column(nullable = false, length = 256)
    private String sKConsentimento;

    @OneToMany(mappedBy = "skInformacaoComplementar")
    private Set<TbProcurador> skInformacaoComplementarTbProcuradors;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "sk_informacao_complementar_id", nullable = false)
    private TbInformacaoComplementar skInformacaoComplementar;

}
