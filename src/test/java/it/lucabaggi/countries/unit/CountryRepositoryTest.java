package it.lucabaggi.countries.unit;

import it.lucabaggi.countries.common.MockServerBaseTest;
import it.lucabaggi.countries.model.Country;
import it.lucabaggi.countries.repository.CountryRepository;
import it.lucabaggi.countries.repository.RestCountriesRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

import static it.lucabaggi.countries.common.Configuration.REMOTE_COUNTRIES_BASE_URI;
import static it.lucabaggi.countries.common.Utils.buildCountry;

@DisplayName("Unit tests for CountryRepository")
public class CountryRepositoryTest extends MockServerBaseTest {

    //sut
    private CountryRepository countryRepository = new RestCountriesRepository(WebClient.create(buildRemoteUrl()));

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

    private static String buildRemoteUrl() {
        return new StringBuilder(mockServer.baseUrl())
                .append(REMOTE_COUNTRIES_BASE_URI)
                .toString();
    }

}
