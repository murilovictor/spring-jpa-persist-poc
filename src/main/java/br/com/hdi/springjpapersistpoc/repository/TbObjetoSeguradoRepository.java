package br.com.hdi.springjpapersistpoc.repository;

import br.com.hdi.springjpapersistpoc.domain.TbObjetoSegurado;
import org.springframework.data.jpa.repository.JpaRepository;


public interface TbObjetoSeguradoRepository extends JpaRepository<TbObjetoSegurado, String> {
}
