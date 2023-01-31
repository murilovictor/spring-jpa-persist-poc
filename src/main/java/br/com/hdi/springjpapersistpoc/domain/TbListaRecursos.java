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
public class TbListaRecursos {

    @Id
    @Column(nullable = false, updatable = false, length = 100)
    private String idRecurso;

    @Column(nullable = false, length = 25)
    private String dsStatusRecurso;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "consentimento_id", nullable = false)
    private TbConsentimento consentimento;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "sk_tipo_recurso_id", nullable = false)
    private TbTipoRecurso skTipoRecurso;

}
