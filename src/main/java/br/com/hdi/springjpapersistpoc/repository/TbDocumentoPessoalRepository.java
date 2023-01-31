package br.com.hdi.springjpapersistpoc.repository;

import br.com.hdi.springjpapersistpoc.domain.TbDocumentoPessoal;
import org.springframework.data.jpa.repository.JpaRepository;


public interface TbDocumentoPessoalRepository extends JpaRepository<TbDocumentoPessoal, Integer> {
}
