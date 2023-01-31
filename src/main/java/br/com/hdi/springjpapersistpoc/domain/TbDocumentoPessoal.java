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
import java.time.LocalDate;
import lombok.Getter;
import lombok.Setter;


@Entity
@Getter
@Setter
public class TbDocumentoPessoal {

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
    private Integer skDocumento;

    @Column(length = 21)
    private String dsTipoDocumento;

    @Column(length = 20)
    private String nrDocumento;

    @Column
    private LocalDate dtExpiracaoDocumento;

    @Column(length = 40)
    private String dsLocalEmissaoDocumento;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "consentimento_id", nullable = false)
    private TbIdentificacaoPessoaConcedente consentimento;

}
