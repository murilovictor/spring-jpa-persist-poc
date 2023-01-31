package br.com.hdi.springjpapersistpoc.dto.auto.info;

import lombok.Data;

@Data
public class AutoInfoCoveragesItemDto {
    private AutoInfoPremiumAmountDto premiumAmount;
    private Integer gracePeriod;
    private Integer daysForTotalCompensation;
    private String code;
    private Integer partialCompensationPercentage;
    private String termEndDate;
    private Integer percentageOverLMI;
    private String susepProcessNumber;
    private String boundCoverage;
    private String description;
    private AutoInfoLMIDto lMI;
    private String type;
    private String gracePeriodEndDate;
    private String branch;
    private Integer adjustmentRate;
    private String feature;
    private String gracePeriodStartDate;
    private String termStartDate;
    private String gracePeriodCountingMethod;
    private String internalCode;
    private String gracePeriodicity;
    private Boolean isMainCoverage;
    private String compensationType;
    private AutoInfoPOSDto pOS;
    private AutoInfoDeductibleDto deductible;
}