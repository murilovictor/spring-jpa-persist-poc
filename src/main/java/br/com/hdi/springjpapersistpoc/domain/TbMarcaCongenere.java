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
public class TbMarcaCongenere {

    @Id
    @Column(nullable = false, updatable = false, length = 80)
    private String nmMarcaCongenere;

    @Column(nullable = false, length = 200)
    private String dsMarcaCongenere;

    @OneToMany(mappedBy = "nmMarcaTransmissora")
    private Set<TbInstituicaoTransmissora> nmMarcaTransmissoraTbInstituicaoTransmissoras;

}
