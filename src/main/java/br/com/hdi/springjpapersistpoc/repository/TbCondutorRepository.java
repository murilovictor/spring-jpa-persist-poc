package br.com.hdi.springjpapersistpoc.repository;

import br.com.hdi.springjpapersistpoc.domain.TbCondutor;
import org.springframework.data.jpa.repository.JpaRepository;


public interface TbCondutorRepository extends JpaRepository<TbCondutor, String> {
}
