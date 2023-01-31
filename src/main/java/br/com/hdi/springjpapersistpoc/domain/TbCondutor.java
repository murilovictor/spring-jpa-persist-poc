package br.com.hdi.springjpapersistpoc.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import java.time.LocalDate;
import lombok.Getter;
import lombok.Setter;


@Entity
@Getter
@Setter
public class TbCondutor {

    @Id
    @Column(nullable = false, updatable = false, length = 256)
    private String sKConsentimento;

    @Column(nullable = false)
    private Integer skRespostaAceitacaoSeguro;

    @Column(nullable = false, length = 14)
    private String nrCnpjcompanhia;

    @Column(nullable = false, length = 20)
    private String dsProdutoSeguroApi;

    @Column(nullable = false, length = 60)
    private String nrDocumentoIdentificacaoCondutor;

    @Column(length = 13)
    private String dsSexoCondutor;

    @Column
    private LocalDate dtNascimentoCondutor;

    @Column
    private Integer qtTempoHabilitacaoCondutor;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "apolice_id", nullable = false)
    private TbInformacaoEspecificaAutoReparo apolice;

}
