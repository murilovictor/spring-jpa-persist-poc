package br.com.hdi.springjpapersistpoc.mapper.impl.commom;

import br.com.hdi.springjpapersistpoc.domain.TbSegurado;
import br.com.hdi.springjpapersistpoc.dto.auto.info.AutoInfoInsuredsItemDto;
import br.com.hdi.springjpapersistpoc.mapper.Converter;
import br.com.hdi.springjpapersistpoc.mapper.impl.dto.InsuredConverterDto;
import org.springframework.stereotype.Component;

@Component
public class InsuredMapper implements Converter<TbSegurado, InsuredConverterDto> {

    @Override
    public InsuredConverterDto toDto(TbSegurado source) {
        return null;
    }

    @Override
    public TbSegurado toEntity(InsuredConverterDto source) {
        AutoInfoInsuredsItemDto infoInsuredsItemDto = source.getData();
        TbSegurado tbSegurado = new TbSegurado();
        tbSegurado.setDsProdutoSeguroApi(source.getDsProdutoSeguroApi());
        tbSegurado.setNrCnpjcompanhia(source.getNrCnpjcompanhia());
        tbSegurado.setConsentimento(source.getTbConsentimento());
        tbSegurado.setSkRespostaAceitacaoSeguro(source.getRespostaAceitacaoSeguro());
        tbSegurado.setIdapolice(source.getApolice().getIdApolice());

        tbSegurado.setNrDocumento(infoInsuredsItemDto.getIdentification());
        tbSegurado.setDsTipoDocumento(infoInsuredsItemDto.getIdentificationType());
        tbSegurado.setNmPessoaFisicaOuRazaoSocial(infoInsuredsItemDto.getName());
        tbSegurado.setNrCep(infoInsuredsItemDto.getPostCode());
        tbSegurado.setDsEmail(infoInsuredsItemDto.getEmail());
        tbSegurado.setNmCidade(infoInsuredsItemDto.getCity());
        tbSegurado.setNmUf(infoInsuredsItemDto.getState());
        tbSegurado.setCdPais(infoInsuredsItemDto.getCountry());
        tbSegurado.setDsEnderecoCompleto(infoInsuredsItemDto.getAddress());

        return tbSegurado;
    }
}
