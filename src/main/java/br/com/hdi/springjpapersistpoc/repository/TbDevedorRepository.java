package br.com.hdi.springjpapersistpoc.repository;

import br.com.hdi.springjpapersistpoc.domain.TbDevedor;
import org.springframework.data.jpa.repository.JpaRepository;


public interface TbDevedorRepository extends JpaRepository<TbDevedor, Integer> {
}
