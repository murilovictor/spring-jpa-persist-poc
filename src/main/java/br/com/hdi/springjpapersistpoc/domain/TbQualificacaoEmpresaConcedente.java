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
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.OffsetDateTime;
import lombok.Getter;
import lombok.Setter;


@Entity
@Getter
@Setter
public class TbQualificacaoEmpresaConcedente {

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
    private OffsetDateTime dtAtualizacao;

    @Column(length = 20)
    private String cdCnaeprincipal;

    @Column(length = 200)
    private String cdCnaesecundario;

    @Column(length = 10)
    private String dsRecorrenciaFaturamento;

    @Column(length = 3)
    private String cdMoedaFaturamento;

    @Column(precision = 22, scale = 2)
    private BigDecimal vlFaturamento;

    @Column(length = 4)
    private String nrAnoReferenciaFaturamento;

    @Column(length = 3)
    private String cdMoedaPatrimonio;

    @Column(precision = 22, scale = 2)
    private BigDecimal vlPatrimonio;

    @Column
    private LocalDate dtReferenciaFaturamento;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "consentimento_id", nullable = false)
    private TbConsentimento consentimento;

}
