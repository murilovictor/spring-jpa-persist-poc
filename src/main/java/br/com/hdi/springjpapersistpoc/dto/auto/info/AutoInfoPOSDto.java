package br.com.hdi.springjpapersistpoc.dto.auto.info;

import lombok.Data;

@Data
public class AutoInfoPOSDto {
    private String applicationType;
    private AutoInfoMinValueDto minValue;
    private AutoInfoMaxValueDto maxValue;
    private Integer percentage;
    private String description;
}