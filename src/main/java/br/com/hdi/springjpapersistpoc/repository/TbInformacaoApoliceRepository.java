package br.com.hdi.springjpapersistpoc.repository;

import br.com.hdi.springjpapersistpoc.domain.TbInformacaoApolice;
import org.springframework.data.jpa.repository.JpaRepository;


public interface TbInformacaoApoliceRepository extends JpaRepository<TbInformacaoApolice, Long> {
}
