package br.com.hdi.springjpapersistpoc.controller;

import br.com.hdi.springjpapersistpoc.dto.auto.info.AutoInfoDto;
import br.com.hdi.springjpapersistpoc.dto.auto.read.AutoReadDto;
import br.com.hdi.springjpapersistpoc.service.auto.AutoInfoService;
import br.com.hdi.springjpapersistpoc.service.auto.AutoReadService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequiredArgsConstructor
public class AutoController {

    private final AutoReadService autoReadService;
    private final AutoInfoService autoInfoService;

    @PostMapping("auto/read/{consentId}")
    public String autoRead(@RequestBody AutoReadDto autoReadDto,
                           @PathVariable String consentId) {

        autoReadService.saveAutoRead(autoReadDto, consentId);

        return "Hello World!";
    }

    @PostMapping("auto/info/{consentId}")
    public String autoInfo(@RequestBody AutoInfoDto autoInfoDto,
                           @PathVariable String consentId) {

        autoInfoService.saveAutoInfo(autoInfoDto, consentId);

        return "Hello World!";
    }

}


//    TbConsentimento tbConsentimentoInsert = new TbConsentimento();
//        tbConsentimentoInsert.setIdConsentimento(UUID.randomUUID().toString());
//                tbConsentimentoInsert.setCdTipoDocumentoPessoaFisica("CPF");
//                tbConsentimentoInsert.setNrDocumentoPessoaFisica("43817853807");
//                tbConsentimentoInsert.setCdTipoDocumentoEmpresaSegurada("CNPJ");
//                tbConsentimentoInsert.setNrDocumentoEmpresaSegurada("000000000000");
//                tbConsentimentoInsert.setDsSentidoConsentimento("R");
//                tbConsentimentoInsert.setDsStatus("AUTHORISED");
//                tbConsentimentoInsert.setTsAtualizacaoStatus(OffsetDateTime.now());
//                tbConsentimentoInsert.setTsAtualizacaoStatus(OffsetDateTime.now());
//                tbConsentimentoInsert.setTsCriacaoConsentimento(OffsetDateTime.now());
//                tbConsentimentoInsert.setTsExpiracaoConsentimento(OffsetDateTime.now());
//                tbConsentimentoInsert.setTsFimTransacao(OffsetDateTime.now());
//                tbConsentimentoInsert.setTsInclusaoConsentimento(OffsetDateTime.now());
//                tbConsentimentoInsert.setTsInicioTransacao(OffsetDateTime.now());