package br.com.hdi.springjpapersistpoc.service.auto;

import br.com.hdi.springjpapersistpoc.domain.TbConsentimento;
import br.com.hdi.springjpapersistpoc.dto.auto.read.AutoReadDataItemDto;
import br.com.hdi.springjpapersistpoc.dto.auto.read.AutoReadDto;
import br.com.hdi.springjpapersistpoc.mapper.impl.auto.AutoReadConverter;
import br.com.hdi.springjpapersistpoc.mapper.impl.dto.AutoReadConverterDto;
import br.com.hdi.springjpapersistpoc.repository.TbRespostaAceitacaoSeguroRepository;
import br.com.hdi.springjpapersistpoc.service.ConsentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AutoReadService {
    private final TbRespostaAceitacaoSeguroRepository respostaAceitacaoSeguroRepository;
    private final AutoReadConverter autoReadConverter;
    private final ConsentService consentService;

    public void saveAutoRead(AutoReadDto autoReadDto, String consentId) {
        TbConsentimento tbConsentimento = consentService.findByConsentId(consentId);

        autoReadDto.getData()
                .stream()
                .map(autoReadDataItemDto -> toAutoReadConverter(tbConsentimento, autoReadDataItemDto))
                .map(autoReadConverter::toEntity)
                .forEach(respostaAceitacaoSeguroRepository::save);

    }

    private static AutoReadConverterDto toAutoReadConverter(TbConsentimento tbConsentimento, AutoReadDataItemDto dataItem) {
        AutoReadConverterDto autoReadConverterDto = new AutoReadConverterDto();
        autoReadConverterDto.setData(dataItem);
        autoReadConverterDto.setDsProdutoSeguroApi("AUTO");
        autoReadConverterDto.setTbConsentimento(tbConsentimento);
        return autoReadConverterDto;
    }

}
