package br.com.hdi.springjpapersistpoc.domain;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import java.util.Set;
import lombok.Getter;
import lombok.Setter;


@Entity
@Getter
@Setter
public class TbCadastroApi {

    @Id
    @Column(nullable = false, updatable = false, length = 200)
    private String nmApi;

    @Column(nullable = false, length = 500)
    private String dsEndPointApi;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(
            name = "tb_respostas_api",
            joinColumns = @JoinColumn(name = "tb_cadastro_api_nm_api"),
            inverseJoinColumns = @JoinColumn(name = "tb_respostas_consulta_api_cd_resposta_consulta_api")
    )
    private Set<TbRespostasConsultaApi> tbRespostasApiTbRespostasConsultaApis;

    @OneToMany(mappedBy = "nmApi")
    private Set<TbTipoConsentimento> nmApiTbTipoConsentimentos;

}
