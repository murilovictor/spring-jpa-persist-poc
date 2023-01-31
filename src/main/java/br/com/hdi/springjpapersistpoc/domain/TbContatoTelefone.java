package br.com.hdi.springjpapersistpoc.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import lombok.Getter;
import lombok.Setter;


@Entity
@Getter
@Setter
public class TbContatoTelefone {

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
    private Integer skTelefone;

    @Column(length = 4)
    private String cdDdi;

    @Column(length = 2)
    private String cdDdd;

    @Column(length = 11)
    private String nrTelefone;

    @Column(length = 5)
    private String nrRamal;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "consentimento_id", nullable = false)
    private TbConsentimento consentimento;

}
