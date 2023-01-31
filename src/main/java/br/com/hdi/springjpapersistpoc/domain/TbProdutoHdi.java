package br.com.hdi.springjpapersistpoc.domain;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.SequenceGenerator;
import java.util.Set;
import lombok.Getter;
import lombok.Setter;


@Entity
@Getter
@Setter
public class TbProdutoHdi {

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
    private Integer skProdutoHdi;

    @Column(nullable = false, length = 50)
    private String nmProdutoHdi;

    @Column(length = 500)
    private String dsProdutoHdi;

    @ManyToMany(mappedBy = "tbProdutoConsentimentoTbProdutoHdis")
    private Set<TbTipoConsentimento> tbProdutoConsentimentoTbTipoConsentimentos;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(
            name = "tb_produto_solicitado",
            joinColumns = @JoinColumn(name = "tb_produto_hdi_sk_produto_hdi"),
            inverseJoinColumns = @JoinColumn(
                            name = "tb_cadastro_solicitacao_consentimento_id_solicitacao_consentimento"
                    )
    )
    private Set<TbCadastroSolicitacaoConsentimento> tbProdutoSolicitadoTbCadastroSolicitacaoConsentimentos;

}
