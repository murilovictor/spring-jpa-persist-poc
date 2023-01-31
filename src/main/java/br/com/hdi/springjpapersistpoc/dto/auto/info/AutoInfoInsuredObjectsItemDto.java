package br.com.hdi.springjpapersistpoc.dto.auto.info;

import lombok.Data;

import java.util.List;

@Data
public class AutoInfoInsuredObjectsItemDto {
    private String modality;
    private String vehicleUsage;
    private String amountReferenceTable;
    private String year;
    private String description;
    private String type;
    private String fareCategory;
    private List<AutoInfoCoveragesItemDto> coverages;
    private String riskPostCode;
    private String identification;
    private Boolean hasExactVehicleIdentification;
    private String typeAdditionalInfo;
    private String frequentDestinationPostCode;
    private String model;
    private String overnightPostCode;
}