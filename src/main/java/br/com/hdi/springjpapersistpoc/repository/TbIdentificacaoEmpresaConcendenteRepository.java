package br.com.hdi.springjpapersistpoc.repository;

import br.com.hdi.springjpapersistpoc.domain.TbIdentificacaoEmpresaConcendente;
import org.springframework.data.jpa.repository.JpaRepository;


public interface TbIdentificacaoEmpresaConcendenteRepository extends JpaRepository<TbIdentificacaoEmpresaConcendente, String> {
}
