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
public class TbOcupacoesPessoaConcedente {

    @Id
    @Column(nullable = false, updatable = false, length = 100)
    private String dsOcupacao;

    @Column(nullable = false)
    private Integer skOcupacaoPessoaConcedente;

    @Column(length = 100)
    private String cdOcupacao;

    @Column(length = 18)
    private String dsTipoCodigoOcupacao;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "consentimento_id", nullable = false)
    private TbQualificacaoPessoaConcedente consentimento;

}
