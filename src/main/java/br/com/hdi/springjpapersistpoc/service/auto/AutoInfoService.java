package br.com.hdi.springjpapersistpoc.service.auto;

import br.com.hdi.springjpapersistpoc.domain.TbApolices;
import br.com.hdi.springjpapersistpoc.domain.TbConsentimento;
import br.com.hdi.springjpapersistpoc.domain.TbInformacaoApolice;
import br.com.hdi.springjpapersistpoc.domain.TbIntermediador;
import br.com.hdi.springjpapersistpoc.domain.TbObjetoSegurado;
import br.com.hdi.springjpapersistpoc.dto.auto.info.AutoInfoDataDto;
import br.com.hdi.springjpapersistpoc.dto.auto.info.AutoInfoDto;
import br.com.hdi.springjpapersistpoc.dto.auto.info.AutoInfoInsuredObjectsItemDto;
import br.com.hdi.springjpapersistpoc.dto.auto.info.AutoInfoInsuredsItemDto;
import br.com.hdi.springjpapersistpoc.dto.auto.info.AutoInfoInsurersItemDto;
import br.com.hdi.springjpapersistpoc.dto.auto.info.AutoInfoIntermediariesItemDto;
import br.com.hdi.springjpapersistpoc.dto.common.BeneficiaryDto;
import br.com.hdi.springjpapersistpoc.mapper.impl.commom.BeneficiaryMapper;
import br.com.hdi.springjpapersistpoc.mapper.impl.commom.CoInsurerMapper;
import br.com.hdi.springjpapersistpoc.mapper.impl.commom.InsuredMapper;
import br.com.hdi.springjpapersistpoc.mapper.impl.commom.PolicyInformationMapper;
import br.com.hdi.springjpapersistpoc.mapper.impl.dto.BeneficiaryConverterDto;
import br.com.hdi.springjpapersistpoc.mapper.impl.dto.CoInsurerConverterDto;
import br.com.hdi.springjpapersistpoc.mapper.impl.dto.InsuredConverterDto;
import br.com.hdi.springjpapersistpoc.mapper.impl.dto.PolicyInformationConverterDto;
import br.com.hdi.springjpapersistpoc.repository.TbInformacaoApoliceRepository;
import br.com.hdi.springjpapersistpoc.service.ConsentService;
import br.com.hdi.springjpapersistpoc.service.PolicyService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
@RequiredArgsConstructor
public class AutoInfoService {
    private final PolicyService policyService;
    private final ConsentService consentService;
    private final TbInformacaoApoliceRepository tbInformacaoApoliceRepository;
    private final PolicyInformationMapper policyInformationMapper;
    private final CoInsurerMapper coInsurerMapper;
    private final InsuredMapper insuredMapper;
    private final BeneficiaryMapper beneficiaryMapper;


    public void saveAutoInfo(AutoInfoDto autoInfoDto, String consentId) {
        AutoInfoDataDto autoInfoDataDto = autoInfoDto.getData();

        TbConsentimento tbConsentimento = consentService.findByConsentId(consentId);
        TbApolices tbApolice = policyService.findByConsentimentoAndPolicyId(tbConsentimento, autoInfoDataDto.getPolicyId());

        if (Objects.isNull(tbApolice)) {
            throw new IllegalArgumentException(String.format("Apolice não localizada. ConsentId: %s - PolicyId: %s",
                    consentId, autoInfoDataDto.getPolicyId()));
        }

        TbInformacaoApolice tbInformacaoApolice = policyInformationMapper
                .toEntity(toPolicyInformationConverterDto(tbConsentimento, autoInfoDataDto, tbApolice));

        autoInfoDataDto.getCoinsurers()
                .stream()
                .map(autoInfoInsurersItemDto -> toCoInsurerConverterDto(autoInfoInsurersItemDto, tbConsentimento, tbApolice))
                .map(coInsurerMapper::toEntity)
                .forEach(tbInformacaoApolice::addCosseguradora);

        autoInfoDataDto.getInsureds()
                .stream()
                .map(autoInfoInsuredsItemDto -> toInsuredConverterDto(autoInfoInsuredsItemDto, tbConsentimento, tbApolice))
                .map(insuredMapper::toEntity)
                .forEach(tbInformacaoApolice::addSegurado);

        autoInfoDataDto.getBeneficiaries()
                .stream()
                .map(beneficiaryDto -> toBeneficiaryConverterDto(beneficiaryDto, tbConsentimento, tbApolice))
                .map(beneficiaryMapper::toEntity)
                .forEach(tbInformacaoApolice::addBeneficiario);

        for (AutoInfoIntermediariesItemDto intermediary : autoInfoDataDto.getIntermediaries()) {
            TbIntermediador tbIntermediador = new TbIntermediador();
            tbIntermediador.setDsProdutoSeguroApi(tbApolice.getDsProdutoSeguroApi());
            tbIntermediador.setNrCnpjcompanhia(tbApolice.getNrCnpjcompanhia());
            tbIntermediador.setConsentimento(tbConsentimento);
            tbIntermediador.setRespostaAceitacaoSeguro(tbApolice.getRespostaAceitacaoSeguro());
            tbIntermediador.setIdapolice(tbApolice.getIdApolice());

            tbIntermediador.setDsTipoIntermediador(intermediary.getType());
            tbIntermediador.setNrDocumento(intermediary.getIdentification());
            tbIntermediador.setIdIntermediador(intermediary.getBrokerId());
            tbIntermediador.setDsTipoDocumento(intermediary.getIdentificationType());
            tbIntermediador.setNmPessoaFisicaOuRazaoSocial(intermediary.getName());
            tbIntermediador.setNrCep(intermediary.getPostCode());
            tbIntermediador.setNmCidade(intermediary.getCity());
            tbIntermediador.setNmUf(intermediary.getState());
            tbIntermediador.setCdPais(intermediary.getCountry());
            tbIntermediador.setDsEnderecoCompleto(intermediary.getAddress());

            tbInformacaoApolice.addIntermediador(tbIntermediador);
        }

        for (AutoInfoInsuredObjectsItemDto insuredObject : autoInfoDataDto.getInsuredObjects()) {
            TbObjetoSegurado tbObjetoSegurado = new TbObjetoSegurado();


        }

        tbInformacaoApoliceRepository.save(tbInformacaoApolice);

    }

    private BeneficiaryConverterDto toBeneficiaryConverterDto(BeneficiaryDto beneficiaryDto,
                                                              TbConsentimento tbConsentimento,
                                                              TbApolices tbApolice) {
        BeneficiaryConverterDto beneficiaryConverterDto = new BeneficiaryConverterDto();
        beneficiaryConverterDto.setData(beneficiaryDto);
        beneficiaryConverterDto.setTbConsentimento(tbConsentimento);
        beneficiaryConverterDto.setApolice(tbApolice);
        beneficiaryConverterDto.setRespostaAceitacaoSeguro(tbApolice.getRespostaAceitacaoSeguro());
        beneficiaryConverterDto.setDsProdutoSeguroApi(tbApolice.getDsProdutoSeguroApi());
        beneficiaryConverterDto.setNrCnpjcompanhia(tbApolice.getNrCnpjcompanhia());

        return beneficiaryConverterDto;
    }

    private InsuredConverterDto toInsuredConverterDto(AutoInfoInsuredsItemDto autoInfoInsuredsItemDto,
                                                      TbConsentimento tbConsentimento,
                                                      TbApolices tbApolice) {
        InsuredConverterDto insuredConverterDto = new InsuredConverterDto();
        insuredConverterDto.setData(autoInfoInsuredsItemDto);
        insuredConverterDto.setTbConsentimento(tbConsentimento);
        insuredConverterDto.setApolice(tbApolice);
        insuredConverterDto.setRespostaAceitacaoSeguro(tbApolice.getRespostaAceitacaoSeguro());
        insuredConverterDto.setDsProdutoSeguroApi(tbApolice.getDsProdutoSeguroApi());
        insuredConverterDto.setNrCnpjcompanhia(tbApolice.getNrCnpjcompanhia());
        return insuredConverterDto;
    }

    private CoInsurerConverterDto toCoInsurerConverterDto(AutoInfoInsurersItemDto autoInfoInsurersItemDto,
                                                          TbConsentimento tbConsentimento,
                                                          TbApolices tbApolice) {
        CoInsurerConverterDto coInsurerConverterDto = new CoInsurerConverterDto();
        coInsurerConverterDto.setData(autoInfoInsurersItemDto);
        coInsurerConverterDto.setTbConsentimento(tbConsentimento);
        coInsurerConverterDto.setApolice(tbApolice);
        coInsurerConverterDto.setRespostaAceitacaoSeguro(tbApolice.getRespostaAceitacaoSeguro());
        coInsurerConverterDto.setDsProdutoSeguroApi(tbApolice.getDsProdutoSeguroApi());
        coInsurerConverterDto.setNrCnpjcompanhia(tbApolice.getNrCnpjcompanhia());
        return coInsurerConverterDto;
    }

    private PolicyInformationConverterDto toPolicyInformationConverterDto(TbConsentimento tbConsentimento,
                                                                          AutoInfoDataDto autoInfoDataDto,
                                                                          TbApolices tbApolice) {
        PolicyInformationConverterDto policyInformationConverterDto = new PolicyInformationConverterDto();
        policyInformationConverterDto.setData(autoInfoDataDto);
        policyInformationConverterDto.setNrCnpjcompanhia(tbApolice.getNrCnpjcompanhia());
        policyInformationConverterDto.setTbConsentimento(tbConsentimento);
        policyInformationConverterDto.setApolice(tbApolice);
        policyInformationConverterDto.setDsProdutoSeguroApi(tbApolice.getDsProdutoSeguroApi());
        policyInformationConverterDto.setRespostaAceitacaoSeguro(tbApolice.getRespostaAceitacaoSeguro());
        return policyInformationConverterDto;
    }
}
