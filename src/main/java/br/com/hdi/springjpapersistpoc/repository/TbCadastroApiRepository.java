package br.com.hdi.springjpapersistpoc.repository;

import br.com.hdi.springjpapersistpoc.domain.TbCadastroApi;
import org.springframework.data.jpa.repository.JpaRepository;


public interface TbCadastroApiRepository extends JpaRepository<TbCadastroApi, String> {
}
