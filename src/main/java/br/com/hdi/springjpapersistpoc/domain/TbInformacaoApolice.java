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
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import static jakarta.persistence.CascadeType.PERSIST;


@Entity
@Getter
@Setter
public class TbInformacaoApolice {

    @Id
    @Column(nullable = false, updatable = false)
    @SequenceGenerator(
            name = "tbinformacaoapolice_skinformacaoapolice_seq",
            sequenceName = "tbinformacaoapolice_skinformacaoapolice_seq",
            allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tbinformacaoapolice_skinformacaoapolice_seq")
    private Long skInformacaoApolice;

    @Column(length = 28)
    private String dsTipoDocumento;

    @Column(length = 60)
    private String nrProcessoSusep;

    @Column(length = 60)
    private String idCertificado;

    @Column(nullable = false, length = 16)
    private String dsTipoEmissao;

    @Column(nullable = false)
    private LocalDate dtEmissaoDocumento;

    @Column(nullable = false)
    private LocalDate dtInicioVigenciaDocumento;

    @Column(nullable = false)
    private LocalDate dtFimVigenciaDocumento;

    @Column(length = 1024)
    private String cdSeguradoraLider;

    @Column(length = 1024)
    private String idApoliceSeguradoraLider;

    @Column(precision = 22, scale = 2)
    private BigDecimal vlLmg;

    @Column(length = 3)
    private String cdMoedaLmg;

    @Column(precision = 21, scale = 9)
    private BigDecimal pcRetidoCosseguro;

    @Column(length = 500)
    private String nmRazaoSocialCedenteRisco;

    @Column(nullable = false)
    private Long sKConsentimento; // TODO alterar para Consentimento

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "skrespostaaceitacaoseguro", nullable = false)
    private TbRespostaAceitacaoSeguro skRespostaAceitacaoSeguro;

    @Column(nullable = false, length = 14)
    private String nrCnpjcompanhia;

    @Column(nullable = false, length = 60)
    private String idProposta;

    @Column(nullable = false, length = 20)
    private String dsProdutoSeguroApi;

    @OneToMany(mappedBy = "informacaoApolice", cascade = PERSIST)
    private Set<TbBeneficiario> beneficiarios;

    @OneToMany(mappedBy = "apolice")
    private Set<TbCoberturaApolice> apoliceTbCoberturaApolices;

    @OneToMany(mappedBy = "informacaoApolice", cascade = PERSIST)
    private Set<TbCosseguradoras> apoliceTbCosseguradoras;

    @OneToMany(mappedBy = "apolice")
    private Set<TbDevedor> apoliceTbDevedors;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "skapolice", nullable = false)
    private TbApolices apolice;

    @OneToMany(mappedBy = "apolice")
    private Set<TbInformacaoEspecificaApoliceSucursalExterior> apoliceTbInformacaoEspecificaApoliceSucursalExteriors;

    @OneToMany(mappedBy = "apolice")
    private Set<TbInformacaoEspecificaAutoReparo> apoliceTbInformacaoEspecificaAutoReparos;

    @OneToMany(mappedBy = "apolice")
    private Set<TbInformacaoEspecificaObjetoSeguradoPatrimonial> apoliceTbInformacaoEspecificaObjetoSeguradoPatrimonials;

    @OneToMany(mappedBy = "apolice")
    private Set<TbInformacaoPremioApolice> apoliceTbInformacaoPremioApolices;

    @OneToMany(mappedBy = "apolice")
    private Set<TbInformacaoSinistroApolice> apoliceTbInformacaoSinistroApolices;

    @OneToMany(mappedBy = "informacaoApolice", cascade = PERSIST)
    private Set<TbIntermediador> intermediadores;

//    @OneToMany(mappedBy = "apolice")
//    private Set<TbObjetoSegurado> apoliceTbObjetoSegurados;

    @OneToMany(mappedBy = "informacaoApolice", cascade = PERSIST)
    private Set<TbSegurado> segurados;

    public void addCosseguradora(TbCosseguradoras tbCosseguradoras) {
        this.getApoliceTbCosseguradoras().add(tbCosseguradoras);
        tbCosseguradoras.setInformacaoApolice(this);
    }

    public Set<TbCosseguradoras> getApoliceTbCosseguradoras() {
        if (apoliceTbCosseguradoras == null) {
            apoliceTbCosseguradoras = new HashSet<>();
        }
        return apoliceTbCosseguradoras;
    }

    public Set<TbSegurado> getSegurados() {
        if (segurados == null) {
            segurados = new HashSet<>();
        }
        return segurados;
    }

    public void addSegurado(TbSegurado tbSegurado) {
        this.getSegurados().add(tbSegurado);
        tbSegurado.setInformacaoApolice(this);
    }

    public Set<TbBeneficiario> getBeneficiarios() {
        if (beneficiarios == null) {
            beneficiarios = new HashSet<>();
        }
        return beneficiarios;
    }

    public void addBeneficiario(TbBeneficiario tbBeneficiario) {
        this.getBeneficiarios().add(tbBeneficiario);
        tbBeneficiario.setInformacaoApolice(this);
    }

    public Set<TbIntermediador> getIntermediadores() {
        if (intermediadores == null) {
            intermediadores = new HashSet<>();
        }
        return intermediadores;
    }

    public void addIntermediador(TbIntermediador tbIntermediador) {
        this.getIntermediadores().add(tbIntermediador);
        tbIntermediador.setInformacaoApolice(this);
    }
}
