package br.com.hdi.springjpapersistpoc.mapper.impl.commom;

import br.com.hdi.springjpapersistpoc.domain.TbBeneficiario;
import br.com.hdi.springjpapersistpoc.dto.common.BeneficiaryDto;
import br.com.hdi.springjpapersistpoc.mapper.Converter;
import br.com.hdi.springjpapersistpoc.mapper.impl.dto.BeneficiaryConverterDto;
import org.springframework.stereotype.Component;

@Component
public class BeneficiaryMapper implements Converter<TbBeneficiario, BeneficiaryConverterDto> {


    @Override
    public BeneficiaryConverterDto toDto(TbBeneficiario source) {
        return null;
    }

    @Override
    public TbBeneficiario toEntity(BeneficiaryConverterDto source) {
        BeneficiaryDto beneficiaryDto = source.getData();

        TbBeneficiario tbBeneficiario = new TbBeneficiario();
        tbBeneficiario.setDsProdutoSeguroApi(source.getDsProdutoSeguroApi());
        tbBeneficiario.setNrCnpjcompanhia(source.getNrCnpjcompanhia());
        tbBeneficiario.setConsentimento(source.getTbConsentimento());
        tbBeneficiario.setRespostaAceitacaoSeguro(source.getRespostaAceitacaoSeguro());
        tbBeneficiario.setIdapolice(source.getApolice().getIdApolice());

        tbBeneficiario.setNrDocumento(beneficiaryDto.getIdentification());
        tbBeneficiario.setDsTipoDocumento(beneficiaryDto.getIdentificationType());
        tbBeneficiario.setNmPessoaFisicaOuRazaoSocial(beneficiaryDto.getName());

        return tbBeneficiario;
    }
}
