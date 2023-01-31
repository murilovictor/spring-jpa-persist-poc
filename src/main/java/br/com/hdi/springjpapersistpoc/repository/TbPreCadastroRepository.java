package br.com.hdi.springjpapersistpoc.repository;

import br.com.hdi.springjpapersistpoc.domain.TbPreCadastro;
import org.springframework.data.jpa.repository.JpaRepository;


public interface TbPreCadastroRepository extends JpaRepository<TbPreCadastro, String> {
}
