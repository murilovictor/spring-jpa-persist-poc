package br.com.hdi.springjpapersistpoc.dto.auto.info;

import br.com.hdi.springjpapersistpoc.dto.common.BeneficiaryDto;
import br.com.hdi.springjpapersistpoc.dto.common.InfoDataCommomDto;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;
import java.util.List;

@Data
@EqualsAndHashCode(callSuper = true)
public class AutoInfoDataDto extends InfoDataCommomDto {
    private String repairedPartsUsageType;
    private String otherCompensations;
    private String termEndDate;
    private Boolean isExpiredRiskPolicy;
    private String leadInsurerCode;
    private List<AutoInfoInsuredObjectsItemDto> insuredObjects;
    private List<AutoInfoPrincipalsItemDto> principals;
    private BigDecimal coinsuranceRetainedPercentage;
    private AutoInfoMaxLMGDto maxLMG;
    private List<AutoInfoCoveragesItemDto> coverages;
    private String proposalId;
    private Integer bonusDiscountRate;
    private String issuanceDate;
    private List<AutoInfoInsurersItemDto> coinsurers;
    private List<BeneficiaryDto> beneficiaries;
    private String repairNetwork;
    private List<AutoInfoInsuredsItemDto> insureds;
    private String leadInsurerPolicyId;
    private String otherBenefits;
    private String issuanceType;
    private String validityType;
    private String repairedPartsClassification;

    private String assistancePackages;
    private String termStartDate;
    private String repairedPartsNationality;
    private List<AutoInfoIntermediariesItemDto> intermediaries;
    private String bonusClass;
    private List<AutoInfoDriversItemDto> drivers;
}