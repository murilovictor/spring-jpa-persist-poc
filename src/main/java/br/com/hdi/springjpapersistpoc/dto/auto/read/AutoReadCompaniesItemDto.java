package br.com.hdi.springjpapersistpoc.dto.auto.read;

import lombok.Data;

import java.util.List;

@Data
public class AutoReadCompaniesItemDto {
    private String companyName;
    private List<String> policies;
    private String cnpjNumber;
}