package br.com.hdi.springjpapersistpoc.domain;

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
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.util.Set;
import lombok.Getter;
import lombok.Setter;


@Entity
@Getter
@Setter
public class TbQualificacaoPessoaConcedente {

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
    private Long id;

    @Column(nullable = false)
    private OffsetDateTime updateDateTime;

    @Column(nullable = false, length = 20)
    private String pepIdentification;

    @Column(nullable = false, length = 13)
    private String lifePensionPlans;

    @Column(length = 10)
    private String incomeFrequencyInformedRevenue;

    @Column(length = 3)
    private String currencyInformedRevenue;

    @Column(precision = 22, scale = 2)
    private BigDecimal amountInformedRevenue;

    @Column
    private LocalDate dateInformedRevenue;

    @Column(length = 3)
    private String currencyInformedPatrimony;

    @Column(precision = 22, scale = 2)
    private BigDecimal amountInformedPatrimony;

    @Column(length = 4)
    private String yearInformedPatrimony;

    @OneToMany(mappedBy = "consentimento")
    private Set<TbOcupacoesPessoaConcedente> consentimentoTbOcupacoesPessoaConcedentes;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "consentimento_id", nullable = false)
    private TbConsentimento consentimento;

}
