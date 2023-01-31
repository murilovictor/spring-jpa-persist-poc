package br.com.hdi.springjpapersistpoc.repository;

import br.com.hdi.springjpapersistpoc.domain.TbContatoEmail;
import org.springframework.data.jpa.repository.JpaRepository;


public interface TbContatoEmailRepository extends JpaRepository<TbContatoEmail, Integer> {
}
