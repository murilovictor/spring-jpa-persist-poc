package br.com.hdi.springjpapersistpoc.service;

import br.com.hdi.springjpapersistpoc.domain.TbApolices;
import br.com.hdi.springjpapersistpoc.domain.TbConsentimento;
import br.com.hdi.springjpapersistpoc.repository.TbApolicesRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PolicyService {
    private final TbApolicesRepository tbApolicesRepository;

    public List<TbApolices> findByConsentimento(TbConsentimento tbConsentimento) {
        List<TbApolices> apolicesList = tbApolicesRepository.findByConsentimento(tbConsentimento);

        if (apolicesList == null || apolicesList.isEmpty()) {
            return new ArrayList<>();
        }

        return apolicesList;
    }

    public TbApolices findByConsentimentoAndPolicyId(TbConsentimento tbConsentimento, String policyId) {
        Optional<TbApolices> policy = tbApolicesRepository.findByConsentimentoAndIdApolice(tbConsentimento, policyId);
        return policy.orElse(null);
    }


}
