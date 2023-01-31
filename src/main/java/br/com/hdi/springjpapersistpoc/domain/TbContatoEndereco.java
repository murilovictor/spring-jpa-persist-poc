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
public class TbContatoEndereco {

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
    private Integer skEndereco;

    @Column(nullable = false, length = 150)
    private String dsLogradouro;

    @Column(length = 30)
    private String dsComplemento;

    @Column(length = 50)
    private String nmBairro;

    @Column(nullable = false, length = 50)
    private String nmCidade;

    @Column(nullable = false, length = 2)
    private String cdUf;

    @Column(nullable = false, length = 8)
    private String nrCep;

    @Column(length = 8)
    private String cdCidadeIbge;

    @Column(nullable = false, length = 60)
    private String nmPais;

    @Column(length = 3)
    private String cdPais;

    @Column(length = 13)
    private String latitude;

    @Column(length = 13)
    private String longitude;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "consentimento_id", nullable = false)
    private TbConsentimento consentimento;

}
