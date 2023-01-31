package br.com.hdi.springjpapersistpoc.repository;

import br.com.hdi.springjpapersistpoc.domain.TbConsentimento;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface TbConsentimentoRepository extends JpaRepository<TbConsentimento, String> {
    Optional<TbConsentimento> findByIdConsentimento(String consentId);
}
