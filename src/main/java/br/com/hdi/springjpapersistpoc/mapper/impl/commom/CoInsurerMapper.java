package br.com.hdi.springjpapersistpoc.mapper.impl.commom;

import br.com.hdi.springjpapersistpoc.domain.TbCosseguradoras;
import br.com.hdi.springjpapersistpoc.dto.auto.info.AutoInfoInsurersItemDto;
import br.com.hdi.springjpapersistpoc.mapper.Converter;
import br.com.hdi.springjpapersistpoc.mapper.impl.dto.CoInsurerConverterDto;
import org.springframework.stereotype.Component;

@Component
public class CoInsurerMapper implements Converter<TbCosseguradoras, CoInsurerConverterDto> {

    @Override
    public CoInsurerConverterDto toDto(TbCosseguradoras source) {
        return null;
    }

    @Override
    public TbCosseguradoras toEntity(CoInsurerConverterDto source) {
        AutoInfoInsurersItemDto autoInfoInsurersItemDto = source.getData();

        TbCosseguradoras tbCosseguradora = new TbCosseguradoras();
        tbCosseguradora.setDsProdutoSeguroApi(source.getDsProdutoSeguroApi());
        tbCosseguradora.setNrCnpjcompanhia(source.getNrCnpjcompanhia());
        tbCosseguradora.setConsentimento(source.getTbConsentimento());
        tbCosseguradora.setSkRespostaAceitacaoSeguro(source.getRespostaAceitacaoSeguro());
        tbCosseguradora.setIdApolice(source.getApolice().getIdApolice());

        tbCosseguradora.setIdCosseguradora(autoInfoInsurersItemDto.getIdentification());
        tbCosseguradora.setPcCedidoCosseguradora(autoInfoInsurersItemDto.getCededPercentage());

        return tbCosseguradora;
    }
}
