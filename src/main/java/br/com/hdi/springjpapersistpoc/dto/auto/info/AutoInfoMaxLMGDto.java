package br.com.hdi.springjpapersistpoc.dto.auto.info;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class AutoInfoMaxLMGDto {
    private BigDecimal amount;
    private String currency;
}