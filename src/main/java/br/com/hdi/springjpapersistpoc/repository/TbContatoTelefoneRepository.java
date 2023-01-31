package br.com.hdi.springjpapersistpoc.repository;

import br.com.hdi.springjpapersistpoc.domain.TbContatoTelefone;
import org.springframework.data.jpa.repository.JpaRepository;


public interface TbContatoTelefoneRepository extends JpaRepository<TbContatoTelefone, Integer> {
}
