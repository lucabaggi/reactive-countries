package it.lucabaggi.countries.repository.mapper;

import it.lucabaggi.countries.model.Country;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface CountryMapper {

    CountryMapper INSTANCE = Mappers.getMapper(CountryMapper.class);

    Country toDomainCountry(it.lucabaggi.countries.repository.model.Country country);
}
