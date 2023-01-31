package br.com.hdi.springjpapersistpoc.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;


@Entity
@Getter
@Setter
public class TbObjetoSeguradoEspecificoPatrimonial {

    @Id
    @Column(nullable = false, updatable = false, length = 256)
    private String sKConsentimento;

    @Column(nullable = false)
    private Integer skRespostaAceitacaoSeguro;

    @Column(nullable = false, length = 14)
    private String nrCnpjcompanhia;

    @Column(nullable = false, length = 20)
    private String dsProdutoSeguroApi;

    @Column(nullable = false, length = 100)
    private String idObjetoSegurado;

    @Column(length = 22)
    private String dsTipoImovelOuCondominioSegurado;

    @Column(length = 21)
    private String dsTipoEstruturacaoCompreensivoCondominio;

    @Column(length = 60)
    private String nrCepObjetoSegurado;

    @Column(length = 7)
    private String cdAtividadeEconomicaIbge;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "apolice_id", nullable = false)
    private TbInformacaoEspecificaObjetoSeguradoPatrimonial apolice;

}
