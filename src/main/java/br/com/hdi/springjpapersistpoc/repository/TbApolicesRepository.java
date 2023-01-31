package br.com.hdi.springjpapersistpoc.repository;

import br.com.hdi.springjpapersistpoc.domain.TbApolices;
import br.com.hdi.springjpapersistpoc.domain.TbConsentimento;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;


public interface TbApolicesRepository extends JpaRepository<TbApolices, String> {

    List<TbApolices> findByConsentimento(TbConsentimento consentimento);

    Optional<TbApolices> findByConsentimentoAndIdApolice(TbConsentimento consentimento, String policyId);

}
