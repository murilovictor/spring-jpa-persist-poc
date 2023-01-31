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
public class TbApolices {

    @Id
    @Column(nullable = false, updatable = false)
    @SequenceGenerator(
            name = "tbapolices_skapolice_seq",
            sequenceName = "tbapolices_skapolice_seq",
            allocationSize = 1)
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "tbapolices_skapolice_seq"
    )
    private Long skApolice;

    @Column(nullable = false, length = 60)
    private String idApolice;

    @Column(nullable = false, length = 14)
    private String nrCnpjcompanhia;

    @Column(nullable = false, length = 20)
    private String dsProdutoSeguroApi;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "skcompanhia", nullable = false)
    private TbCompanhia companhia;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "skrespostaaceitacaoseguro", nullable = false)
    private TbRespostaAceitacaoSeguro respostaAceitacaoSeguro;

    @OneToMany(mappedBy = "apolice", cascade = CascadeType.PERSIST)
    private Set<TbInformacaoApolice> apoliceTbInformacaoApolices;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "skconsentimento", nullable = false)
    private TbConsentimento consentimento;


    public Set<TbInformacaoApolice> getApoliceTbInformacaoApolices() {
        if (apoliceTbInformacaoApolices == null) {
            apoliceTbInformacaoApolices = new HashSet<>();
        }
        return apoliceTbInformacaoApolices;
    }

    public void addTbInformacaoApolice(TbInformacaoApolice apolice) {
        this.getApoliceTbInformacaoApolices().add(apolice);
        apolice.setApolice(this);
    }
}
