package br.com.hdi.springjpapersistpoc.repository;

import br.com.hdi.springjpapersistpoc.domain.TbCompanhia;
import org.springframework.data.jpa.repository.JpaRepository;


public interface TbCompanhiaRepository extends JpaRepository<TbCompanhia, String> {
}
