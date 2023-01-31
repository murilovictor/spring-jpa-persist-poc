package br.com.hdi.springjpapersistpoc.service;

import br.com.hdi.springjpapersistpoc.domain.TbConsentimento;
import br.com.hdi.springjpapersistpoc.repository.TbConsentimentoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ConsentService {
    private final TbConsentimentoRepository consentimentoRepository;

    public TbConsentimento findByConsentId(String consentId) {
        Optional<TbConsentimento> tbConsentimentoOptional = consentimentoRepository.findByIdConsentimento(consentId);

        if (tbConsentimentoOptional.isEmpty()) {
            throw new IllegalArgumentException("Consentimento não localizado. ");
        }

        return tbConsentimentoOptional.get();
    }


}
