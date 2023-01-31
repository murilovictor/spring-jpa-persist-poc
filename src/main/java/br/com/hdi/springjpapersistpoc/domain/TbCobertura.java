package br.com.hdi.springjpapersistpoc.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import java.util.Set;
import lombok.Getter;
import lombok.Setter;


@Entity
@Getter
@Setter
public class TbCobertura {

    @Id
    @Column(nullable = false, updatable = false, length = 150)
    private String cdCobertura;

    @OneToMany(mappedBy = "cdCobertura")
    private Set<TbCoberturaApolice> cdCoberturaTbCoberturaApolices;

    @OneToMany(mappedBy = "cdCobertura")
    private Set<TbCoberturasObjetosSegurados> cdCoberturaTbCoberturasObjetosSeguradoss;

    @OneToMany(mappedBy = "cdCobertura")
    private Set<TbCoberturasPremio> cdCoberturaTbCoberturasPremios;

}
