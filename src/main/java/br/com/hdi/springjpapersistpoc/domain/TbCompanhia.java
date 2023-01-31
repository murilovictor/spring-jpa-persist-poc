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
import java.util.Objects;
import java.util.Set;


@Entity
@Getter
@Setter
public class TbCompanhia {

    @Id
    @Column(nullable = false, updatable = false)
    @SequenceGenerator(
            name = "tbcompanhia_skcompanhia_seq",
            sequenceName = "tbcompanhia_skcompanhia_seq",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "tbcompanhia_skcompanhia_seq"
    )
    private Long skCompanhia;

    @Column(length = 14)
    private String nrCnpjcompanhia;

    @Column(nullable = false, length = 70)
    private String nmCompanhia;

    @Column(nullable = false, length = 20)
    private String dsProdutoSeguroApi;

    @OneToMany(mappedBy = "companhia", cascade = CascadeType.PERSIST)
    private Set<TbApolices> consentimentoTbApolices;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "skrespostaaceitacaoseguro", nullable = false)
    private TbRespostaAceitacaoSeguro respostaAceitacaoSeguro;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "skconsentimento", nullable = false)
    private TbConsentimento tbConsentimento;


    public void addApolice(TbApolices tbApolices) {
        getConsentimentoTbApolices().add(tbApolices);
        tbApolices.setCompanhia(this);
    }

    public void removeApolice(TbApolices tbApolices) {
        getConsentimentoTbApolices().remove(tbApolices);
        tbApolices.setCompanhia(null);
    }

    public Set<TbApolices> getConsentimentoTbApolices() {
        if (consentimentoTbApolices == null) {
            consentimentoTbApolices = new HashSet<>();
        }
        return consentimentoTbApolices;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TbCompanhia that = (TbCompanhia) o;
        return Objects.equals(nrCnpjcompanhia, that.nrCnpjcompanhia);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nrCnpjcompanhia);
    }
}
