package it.lucabaggi.countries.repository;

import it.lucabaggi.countries.model.Country;
import it.lucabaggi.countries.repository.mapper.CountryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

@Repository
public class RestCountriesRepository implements CountryRepository {

    private WebClient webClient;

    @Autowired
    public RestCountriesRepository(WebClient webClient) {
        this.webClient = webClient;
    }

    @Override
    public Flux<Country> getCountries(String name) {
        return webClient.get()
                .uri("/name/{name}", name)
                .retrieve()
                .bodyToFlux(it.lucabaggi.countries.repository.model.Country.class)
                .map(CountryMapper.INSTANCE::toDomainCountry);

    }
}
