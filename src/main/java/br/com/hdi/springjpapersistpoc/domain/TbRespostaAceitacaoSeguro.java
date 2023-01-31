package br.com.hdi.springjpapersistpoc.domain;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;


@Entity
@Getter
@Setter
public class TbRespostaAceitacaoSeguro {

    @Id
    @Column(nullable = false, updatable = false)
    @SequenceGenerator(
            name = "tbrespostaaceitacaoseguro_skrespostaaceitacaoseguro_seq",
            sequenceName = "tbrespostaaceitacaoseguro_skrespostaaceitacaoseguro_seq",
            allocationSize = 1)
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "tbrespostaaceitacaoseguro_skrespostaaceitacaoseguro_seq"
    )
    private Long skRespostaAceitacaoSeguro;

    @Column(nullable = false, length = 80)
    private String nmMarcaCongenere;

    @Column(nullable = false, length = 20)
    private String dsProdutoSeguroApi;

    @OneToMany(mappedBy = "respostaAceitacaoSeguro", cascade = CascadeType.PERSIST)
    private Set<TbCompanhia> consentimentoTbCompanhias;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "sKConsentimento", nullable = false)
    private TbConsentimento consentimento;

    public void addCompanhia(TbCompanhia tbCompanhia) {
        getConsentimentoTbCompanhias().add(tbCompanhia);
        tbCompanhia.setRespostaAceitacaoSeguro(this);
    }

    public void removeCompanhia(TbCompanhia tbCompanhia) {
        getConsentimentoTbCompanhias().remove(tbCompanhia);
        tbCompanhia.setRespostaAceitacaoSeguro(null);
    }

    public Set<TbCompanhia> getConsentimentoTbCompanhias() {
        if (consentimentoTbCompanhias == null) {
            consentimentoTbCompanhias = new HashSet<>();
        }
        return consentimentoTbCompanhias;
    }
}
