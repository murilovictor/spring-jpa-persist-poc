package br.com.hdi.springjpapersistpoc.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.util.Set;
import lombok.Getter;
import lombok.Setter;


@Entity
@Getter
@Setter
public class TbIdentificacaoEmpresaConcendente {

    @Id
    @Column(nullable = false, updatable = false, length = 100)
    private String idEmpresaConcedente;

    @Column(length = 14)
    private String nrCnpjempresaConcedente;

    @Column(length = 20)
    private String nrIdentificacaoEmpresaConcedenteEstrangeira;

    @Column(length = 3)
    private String cdPaisEmissorDocumento;

    @Column
    private LocalDate dtExpiracaoDocumento;

    @Column(length = 7)
    private String tipoEmpresaConcedente;

    @Column(nullable = false, length = 70)
    private String nmRazaoSocialEmpresaConcedente;

    @Column(length = 70)
    private String nmFantasiaEmpresaConcedente;

    @Column
    private LocalDate dtConstituicaoEmpresaConcendente;

    @Column(nullable = false, length = 80)
    private String nmMarcaCongenere;

    @Column(nullable = false, length = 14)
    private String nrCnpjcongenere;

    @Column(nullable = false, length = 70)
    private String nmCompanhiaCongenere;

    @Column(nullable = false)
    private OffsetDateTime tsAtualizacao;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "consentimento_id", nullable = false)
    private TbConsentimento consentimento;

    @OneToMany(mappedBy = "consentimento")
    private Set<TbSociosAdmEmpresaConcedente> consentimentoTbSociosAdmEmpresaConcedentes;

}
