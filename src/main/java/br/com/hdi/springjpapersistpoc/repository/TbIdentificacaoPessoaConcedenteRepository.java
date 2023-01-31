package br.com.hdi.springjpapersistpoc.repository;

import br.com.hdi.springjpapersistpoc.domain.TbIdentificacaoPessoaConcedente;
import org.springframework.data.jpa.repository.JpaRepository;


public interface TbIdentificacaoPessoaConcedenteRepository extends JpaRepository<TbIdentificacaoPessoaConcedente, String> {
}
