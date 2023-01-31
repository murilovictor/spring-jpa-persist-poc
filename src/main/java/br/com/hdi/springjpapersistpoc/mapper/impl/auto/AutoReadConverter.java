package br.com.hdi.springjpapersistpoc.mapper.impl.auto;

import br.com.hdi.springjpapersistpoc.domain.TbApolices;
import br.com.hdi.springjpapersistpoc.domain.TbCompanhia;
import br.com.hdi.springjpapersistpoc.domain.TbConsentimento;
import br.com.hdi.springjpapersistpoc.domain.TbRespostaAceitacaoSeguro;
import br.com.hdi.springjpapersistpoc.dto.auto.read.AutoReadCompaniesItemDto;
import br.com.hdi.springjpapersistpoc.dto.auto.read.AutoReadDataItemDto;
import br.com.hdi.springjpapersistpoc.mapper.Converter;
import br.com.hdi.springjpapersistpoc.mapper.impl.dto.AutoReadConverterDto;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AutoReadConverter implements Converter<TbRespostaAceitacaoSeguro, AutoReadConverterDto> {


    @Override
    public AutoReadConverterDto toDto(TbRespostaAceitacaoSeguro source) {
        return null;
    }

    @Override
    public TbRespostaAceitacaoSeguro toEntity(AutoReadConverterDto source) {
        TbConsentimento tbConsentimento = source.getTbConsentimento();
        AutoReadDataItemDto dataItem = source.getData();

        TbRespostaAceitacaoSeguro tbRespostaAceitacaoSeguro = new TbRespostaAceitacaoSeguro();
        tbRespostaAceitacaoSeguro.setNmMarcaCongenere(dataItem.getBrand());
        tbRespostaAceitacaoSeguro.setDsProdutoSeguroApi(source.getDsProdutoSeguroApi());
        tbRespostaAceitacaoSeguro.setConsentimento(tbConsentimento);

        List<AutoReadCompaniesItemDto> companies = dataItem.getCompanies();

        for (AutoReadCompaniesItemDto company : companies) {

            TbCompanhia tbCompanhia = new TbCompanhia();
            tbCompanhia.setNmCompanhia(company.getCompanyName());
            tbCompanhia.setNrCnpjcompanhia(company.getCnpjNumber());
            tbCompanhia.setDsProdutoSeguroApi(source.getDsProdutoSeguroApi());
            tbCompanhia.setTbConsentimento(tbConsentimento);
            tbCompanhia.setRespostaAceitacaoSeguro(tbRespostaAceitacaoSeguro);

            tbRespostaAceitacaoSeguro.addCompanhia(tbCompanhia);

            List<String> policies = company.getPolicies();

            for (String policy : policies) {
                TbApolices tbApolices = new TbApolices();
                tbApolices.setIdApolice(policy);
                tbApolices.setDsProdutoSeguroApi(source.getDsProdutoSeguroApi());
                tbApolices.setCompanhia(tbCompanhia);
                tbApolices.setConsentimento(tbConsentimento);
                tbApolices.setNrCnpjcompanhia(tbCompanhia.getNrCnpjcompanhia());
                tbApolices.setRespostaAceitacaoSeguro(tbRespostaAceitacaoSeguro);

                tbCompanhia.addApolice(tbApolices);
            }

        }
        return tbRespostaAceitacaoSeguro;
    }
}
