package br.com.hdi.springjpapersistpoc.mapper;

import br.com.hdi.springjpapersistpoc.domain.TbApolices;
import br.com.hdi.springjpapersistpoc.domain.TbConsentimento;
import br.com.hdi.springjpapersistpoc.domain.TbRespostaAceitacaoSeguro;
import lombok.Data;

@Data
public class ConverterDto<T> {

    private T data;
    private TbConsentimento tbConsentimento;
    private String dsProdutoSeguroApi;
    private String nrCnpjcompanhia;
    private TbRespostaAceitacaoSeguro respostaAceitacaoSeguro;
    private TbApolices apolice;

}
