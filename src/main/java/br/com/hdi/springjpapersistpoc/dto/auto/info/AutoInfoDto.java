package br.com.hdi.springjpapersistpoc.dto.auto.info;

import lombok.Data;

@Data
public class AutoInfoDto {
    private AutoInfoDataDto data;
    private Meta meta;
    private Links links;
}