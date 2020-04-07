package it.lucabaggi.countries.service;

import it.lucabaggi.countries.model.Country;
import reactor.core.publisher.Flux;

public interface CountryService {

    Flux<Country> getCountries(String name);
}
