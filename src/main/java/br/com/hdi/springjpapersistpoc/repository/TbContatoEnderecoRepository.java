package br.com.hdi.springjpapersistpoc.repository;

import br.com.hdi.springjpapersistpoc.domain.TbContatoEndereco;
import org.springframework.data.jpa.repository.JpaRepository;


public interface TbContatoEnderecoRepository extends JpaRepository<TbContatoEndereco, Integer> {
}
