package it.lucabaggi.countries.repository;

import it.lucabaggi.countries.model.Country;
import reactor.core.publisher.Flux;

import java.util.List;

public interface CountryRepository {

    /**
     *
     * @param name
     * @return all countries matching name passed as parameter
     */
    Flux<Country> getCountries(String name);
}
