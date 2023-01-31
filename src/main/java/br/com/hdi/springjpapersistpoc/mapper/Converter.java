package br.com.hdi.springjpapersistpoc.mapper;

public interface Converter<E, D extends ConverterDto<?>> {

    D toDto(E source);

    E toEntity(D source);

}