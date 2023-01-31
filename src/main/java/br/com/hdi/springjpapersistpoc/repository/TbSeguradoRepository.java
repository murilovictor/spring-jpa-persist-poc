package br.com.hdi.springjpapersistpoc.repository;

import br.com.hdi.springjpapersistpoc.domain.TbSegurado;
import org.springframework.data.jpa.repository.JpaRepository;


public interface TbSeguradoRepository extends JpaRepository<TbSegurado, String> {
}
