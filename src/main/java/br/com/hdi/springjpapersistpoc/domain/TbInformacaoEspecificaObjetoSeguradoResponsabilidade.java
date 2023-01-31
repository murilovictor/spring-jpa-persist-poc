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
import lombok.Getter;
import lombok.Setter;


@Entity
@Getter
@Setter
public class TbInformacaoEspecificaObjetoSeguradoResponsabilidade {

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

    @Column
    private Boolean flContratoComplementar;

    @Column(precision = 22, scale = 2)
    private BigDecimal vlContratoComplementar;

    @Column(length = 3)
    private String cdMoedaContratoComplementar;

    @Column(precision = 22, scale = 2)
    private BigDecimal vlMaxCoberturaPassivoAmbientalDesconhecido;

    @Column
    private LocalDate dtInicioCoberturaPassivoAmbientalDesconhecido;

    @Column
    private LocalDate dtFimCoberturaPassivoAmbientalDesconhecido;

    @Column(length = 100)
    private String dsPrazoCoberturaPassivoAmbientalDesconhecido;

    @Column(length = 3)
    private String dsUnidadeCoberturaPassivoAmbientalDesconhecido;

    @Column(length = 13)
    private String dsIndicadorDiasUteisCoberturaPassivoAmbientalDesconhecido;

    @Column
    private Boolean flApoliceEnglobaDanosPoluicaoTransporte;

    @Column
    private Boolean flApoliceEnglobaDanosOriginadosLocaisTerceiros;

    @Column(length = 80)
    private String dsClasseProfissional;

    @Column
    private Boolean flAplicacaoRetroatividade;

    @Column(nullable = false, length = 60)
    private String idApolice;

    @Column(nullable = false, length = 256)
    private String sKConsentimento;

    @Column(nullable = false)
    private Integer skRespostaAceitacaoSeguro;

    @Column(nullable = false, length = 14)
    private String nrCnpjcompanhia;

    @Column(nullable = false, length = 20)
    private String dsProdutoSeguroApi;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "objeto_segurado_id", nullable = false)
    private TbObjetoSegurado objetoSegurado;

}
