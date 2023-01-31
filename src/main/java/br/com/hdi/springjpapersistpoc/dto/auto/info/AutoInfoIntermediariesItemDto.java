package br.com.hdi.springjpapersistpoc.dto.auto.info;

import lombok.Data;

@Data
public class AutoInfoIntermediariesItemDto {
    private String country;
    private String brokerId;
    private String identification;
    private String address;
    private String city;
    private String name;
    private String identificationType;
    private String postCode;
    private String state;
    private String type;
}