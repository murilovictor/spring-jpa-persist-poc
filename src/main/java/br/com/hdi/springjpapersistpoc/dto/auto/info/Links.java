package br.com.hdi.springjpapersistpoc.dto.auto.info;

import lombok.Data;

@Data
public class Links {
    private String next;
    private String last;
    private String prev;
    private String self;
    private String first;
}