package br.com.hdi.springjpapersistpoc.repository;

import br.com.hdi.springjpapersistpoc.domain.TbCobertura;
import org.springframework.data.jpa.repository.JpaRepository;


public interface TbCoberturaRepository extends JpaRepository<TbCobertura, String> {
}
