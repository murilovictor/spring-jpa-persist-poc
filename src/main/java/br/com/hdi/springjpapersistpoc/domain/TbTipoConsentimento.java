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
import java.util.Set;
import lombok.Getter;
import lombok.Setter;


@Entity
@Getter
@Setter
public class TbTipoConsentimento {

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
    private Integer skTipoConsentimento;

    @Column(nullable = false, length = 100)
    private String nmTipoConsentimento;

    @Column(nullable = false)
    private Boolean flObrigatorio;

    @Column(nullable = false, length = 100)
    private String dsTipoConsentimento;

    @ManyToMany(mappedBy = "tbConsentimentoTipoConsentimentoTbTipoConsentimentos")
    private Set<TbConsentimento> tbConsentimentoTipoConsentimentoTbConsentimentos;

    @OneToMany(mappedBy = "skTipoConsentimento")
    private Set<TbFilaCosultasApienviadas> skTipoConsentimentoTbFilaCosultasApienviadass;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(
            name = "tb_produto_consentimento",
            joinColumns = @JoinColumn(name = "tb_tipo_consentimento_sk_tipo_consentimento"),
            inverseJoinColumns = @JoinColumn(name = "tb_produto_hdi_sk_produto_hdi")
    )
    private Set<TbProdutoHdi> tbProdutoConsentimentoTbProdutoHdis;

    @OneToMany(mappedBy = "skTipoConsentimento")
    private Set<TbTabelasDadosTipoConsentimento> skTipoConsentimentoTbTabelasDadosTipoConsentimentos;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "nm_api_id")
    private TbCadastroApi nmApi;

}
