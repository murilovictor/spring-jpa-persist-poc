package br.com.hdi.springjpapersistpoc.repository;

import br.com.hdi.springjpapersistpoc.domain.TbBeneficiario;
import org.springframework.data.jpa.repository.JpaRepository;


public interface TbBeneficiRioRepository extends JpaRepository<TbBeneficiario, Integer> {
}
