package br.com.hdi.springjpapersistpoc.dto.auto.info;

import lombok.Data;

@Data
public class AutoInfoDeductibleDto {
    private String periodCountingMethod;
    private String periodStartDate;
    private AutoInfoAmountDto amount;
    private Integer period;
    private String typeAdditionalInfo;
    private String periodicity;
    private String description;
    private Boolean hasDeductibleOverTotalCompensation;
    private String type;
    private String periodEndDate;
}