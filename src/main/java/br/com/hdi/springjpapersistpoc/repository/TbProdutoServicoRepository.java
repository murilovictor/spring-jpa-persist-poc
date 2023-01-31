package br.com.hdi.springjpapersistpoc.repository;

import br.com.hdi.springjpapersistpoc.domain.TbProdutoServico;
import org.springframework.data.jpa.repository.JpaRepository;


public interface TbProdutoServicoRepository extends JpaRepository<TbProdutoServico, String> {
}
