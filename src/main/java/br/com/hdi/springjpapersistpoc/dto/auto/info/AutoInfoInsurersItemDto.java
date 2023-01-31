package br.com.hdi.springjpapersistpoc.dto.auto.info;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class AutoInfoInsurersItemDto {
    private String identification;
    private BigDecimal cededPercentage;
}