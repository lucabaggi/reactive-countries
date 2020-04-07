package it.lucabaggi.countries.integration;

import it.lucabaggi.countries.model.Country;
import it.lucabaggi.countries.repository.CountryRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.reactive.function.client.WebClientResponseException;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

import static it.lucabaggi.countries.common.Utils.*;

@DisplayName("Integration tests for CountryRepository")
public class CountryRepositoryIT extends BaseIntegrationTest {

    //sut
    @Autowired
    private CountryRepository countryRepository;

    @Test
    public void shouldReturnCountryList() {
        //given
        final String countrySearchText = "italy";
        super.stubPositiveResponse(countrySearchText);

        //when
        Flux<Country> countries = countryRepository.getCountries(countrySearchText);

        //then
        StepVerifier.create(countries)
                .expectNext(buildCountry())
                .verifyComplete();
    }

    @Test
    public void shouldThrowRemoteWebException() {
        //given
        final String invalidCountrySearchText = "invalid_country";
        super.stubNotFoundResponse(invalidCountrySearchText);

        //when
        Flux<Country> countries = countryRepository.getCountries(invalidCountrySearchText);

        //then
        StepVerifier.create(countries)
                .expectErrorMatches(throwable -> throwable instanceof WebClientResponseException &&
                        ((WebClientResponseException) throwable).getStatusCode().equals(HttpStatus.NOT_FOUND))
                .verify();
    }

}
