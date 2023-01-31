package br.com.hdi.springjpapersistpoc.mapper.impl.commom;

import br.com.hdi.springjpapersistpoc.domain.TbInformacaoApolice;
import br.com.hdi.springjpapersistpoc.dto.auto.info.AutoInfoDataDto;
import br.com.hdi.springjpapersistpoc.mapper.Converter;
import br.com.hdi.springjpapersistpoc.mapper.impl.dto.PolicyInformationConverterDto;
import br.com.hdi.springjpapersistpoc.util.DateUtil;
import org.springframework.stereotype.Component;

@Component
public class PolicyInformationMapper implements Converter<TbInformacaoApolice, PolicyInformationConverterDto> {

    @Override
    public PolicyInformationConverterDto toDto(TbInformacaoApolice source) {
        return null;
    }

    @Override
    public TbInformacaoApolice toEntity(PolicyInformationConverterDto source) {
        AutoInfoDataDto autoInfoDataDto = source.getData();

        TbInformacaoApolice tbInformacaoApolice = new TbInformacaoApolice();
        tbInformacaoApolice.setSKConsentimento(source.getTbConsentimento().getSKConsentimento());
        tbInformacaoApolice.setSkRespostaAceitacaoSeguro(source.getRespostaAceitacaoSeguro());
        tbInformacaoApolice.setNrCnpjcompanhia(source.getNrCnpjcompanhia());
        tbInformacaoApolice.setApolice(source.getApolice());
        tbInformacaoApolice.setDsProdutoSeguroApi(source.getDsProdutoSeguroApi());

        tbInformacaoApolice.setDsTipoDocumento(autoInfoDataDto.getDocumentType());
        tbInformacaoApolice.setNrProcessoSusep(autoInfoDataDto.getSusepProcessNumber());
        tbInformacaoApolice.setIdCertificado(autoInfoDataDto.getGroupCertificateId());
        tbInformacaoApolice.setDsTipoEmissao(autoInfoDataDto.getIssuanceType());
        tbInformacaoApolice.setDtEmissaoDocumento(DateUtil.strToLocalDate(autoInfoDataDto.getIssuanceDate()));
        tbInformacaoApolice.setDtInicioVigenciaDocumento(DateUtil.strToLocalDate(autoInfoDataDto.getTermStartDate()));
        tbInformacaoApolice.setDtFimVigenciaDocumento(DateUtil.strToLocalDate(autoInfoDataDto.getTermEndDate()));
        tbInformacaoApolice.setCdSeguradoraLider(autoInfoDataDto.getLeadInsurerCode());
        tbInformacaoApolice.setIdApoliceSeguradoraLider(autoInfoDataDto.getLeadInsurerPolicyId());
        tbInformacaoApolice.setVlLmg(autoInfoDataDto.getMaxLMG().getAmount());
        tbInformacaoApolice.setCdMoedaLmg(autoInfoDataDto.getMaxLMG().getCurrency());
        tbInformacaoApolice.setIdProposta(autoInfoDataDto.getProposalId());
        tbInformacaoApolice.setPcRetidoCosseguro(autoInfoDataDto.getCoinsuranceRetainedPercentage());

        return tbInformacaoApolice;
    }
}
