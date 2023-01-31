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
import java.time.OffsetDateTime;
import lombok.Getter;
import lombok.Setter;


@Entity
@Getter
@Setter
public class TbFilaCosultasApienviadas {

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
    private Integer skConsultaApi;

    @Column(length = 1000)
    private String dsChamadaEndpoint;

    @Column
    private OffsetDateTime tsConsultaEnviada;

    @Column
    private OffsetDateTime tsRetornoConsultaEnviada;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "solicitacao_consentimento_id", nullable = false)
    private TbCadastroSolicitacaoConsentimento solicitacaoConsentimento;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "sk_tipo_consentimento_id")
    private TbTipoConsentimento skTipoConsentimento;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cd_resposta_consulta_api_id")
    private TbRespostasConsultaApi cdRespostaConsultaApi;

}
