package it.lucabaggi.countries.service;

import it.lucabaggi.countries.model.Country;
import it.lucabaggi.countries.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
public class CountryServiceImpl implements CountryService {

    private CountryRepository countryRepository;

    @Autowired
    public CountryServiceImpl(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    @Override
    public Flux<Country> getCountries(String name) {
        return countryRepository.getCountries(name);
    }
}
