package br.com.hdi.springjpapersistpoc.dto.auto.info;

import lombok.Data;

@Data
public class AutoInfoDriversItemDto {
    private String identification;
    private Integer licensedExperience;
    private String sex;
    private String birthDate;
}