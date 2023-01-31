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
public class TbInformacaoAnexoEspecificoSinistroRural {

    @Id
    @Column(nullable = false, updatable = false, length = 256)
    private String sKConsentimento;

    @Column(nullable = false)
    private Integer skRespostaAceitacaoSeguro;

    @Column(nullable = false, length = 14)
    private String nrCnpjcompanhia;

    @Column(nullable = false, length = 50)
    private String idProcessoSinistro;

    @Column(nullable = false, length = 20)
    private String dsProdutoSeguroApi;

    @Column
    private LocalDate dtVistoria;

    @Column(length = 2)
    private String sgUffVistoria;

    @Column(length = 100)
    private String dsLocalVistoria;

    @Column(length = 30)
    private String nrCepVistoria;

    @Column(length = 3)
    private String cdPaisVistoria;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "apolice_id", nullable = false)
    private TbInformacaoSinistroApolice apolice;

}
