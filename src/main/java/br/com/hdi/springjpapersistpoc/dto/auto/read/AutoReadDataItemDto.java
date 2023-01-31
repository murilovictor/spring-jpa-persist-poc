package br.com.hdi.springjpapersistpoc.dto.auto.read;

import lombok.Data;

import java.util.List;

@Data
public class AutoReadDataItemDto {
    private List<AutoReadCompaniesItemDto> companies;
    private String brand;
}