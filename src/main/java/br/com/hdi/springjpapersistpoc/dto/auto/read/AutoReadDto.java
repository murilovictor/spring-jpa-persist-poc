package br.com.hdi.springjpapersistpoc.dto.auto.read;

import lombok.Data;

import java.util.List;

@Data
public class AutoReadDto {
    private List<AutoReadDataItemDto> data;

}