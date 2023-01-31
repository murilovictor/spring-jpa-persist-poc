package br.com.hdi.springjpapersistpoc.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import java.util.Set;
import lombok.Getter;
import lombok.Setter;


@Entity
@Getter
@Setter
public class TbRespostasConsultaApi {

    @Id
    @Column(nullable = false, updatable = false, length = 100)
    private String cdRespostaConsultaApi;

    @Column(nullable = false, length = 200)
    private String dsRespostaConsultaApi;

    @Column(nullable = false)
    private Boolean flRessubmeterAutomaticamente;

    @OneToMany(mappedBy = "cdRespostaConsultaApi")
    private Set<TbFilaCosultasApienviadas> cdRespostaConsultaApiTbFilaCosultasApienviadass;

    @ManyToMany(mappedBy = "tbRespostasApiTbRespostasConsultaApis")
    private Set<TbCadastroApi> tbRespostasApiTbCadastroApis;

}
