package br.com.hdi.springjpapersistpoc.mapper.impl.commom;

import br.com.hdi.springjpapersistpoc.domain.TbIntermediador;
import br.com.hdi.springjpapersistpoc.mapper.Converter;
import br.com.hdi.springjpapersistpoc.mapper.impl.dto.IntermediaryConverterDto;
import org.springframework.stereotype.Component;

@Component
public class IntermediaryMapper implements Converter<TbIntermediador, IntermediaryConverterDto> {


    @Override
    public IntermediaryConverterDto toDto(TbIntermediador source) {
        return null;
    }

    @Override
    public TbIntermediador toEntity(IntermediaryConverterDto source) {
        return null;
    }
}
