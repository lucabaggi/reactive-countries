package it.lucabaggi.countries.integration;

import it.lucabaggi.countries.model.ApiError;
import it.lucabaggi.countries.model.Country;
import it.lucabaggi.countries.model.ErrorCode;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.test.web.reactive.server.WebTestClient;

import static it.lucabaggi.countries.common.Configuration.COUNTRIES_ENDPOINT_URI;
import static it.lucabaggi.countries.common.Utils.buildCountry;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasSize;

@AutoConfigureWebTestClient
@DisplayName("Integration tests for CountryController")
public class CountryControllerIT extends BaseIntegrationTest {

    @Autowired
    private WebTestClient webTestClient;

    @Test
    public void shouldReturnOkResponseWithBody() {
        //given
        final String countrySearchText = "italy";
        super.stubPositiveResponse(countrySearchText);

        //when
        webTestClient.get()
                .uri(String.format(COUNTRIES_ENDPOINT_URI, countrySearchText))
                .exchange()
                .expectStatus().isOk() //then
                .expectBodyList(Country.class)
                .value(countries -> hasSize(1))
                .value(countries -> countries.get(0), equalTo(buildCountry()));
    }

    @Test
    public void shouldReturnNotFoundResponse() {
        //given
        final String invalidCountrySearchText = "invalid_country";
        super.stubNotFoundResponse(invalidCountrySearchText);

        //when
        webTestClient.get()
                .uri(String.format(COUNTRIES_ENDPOINT_URI, invalidCountrySearchText))
                .exchange()
                .expectStatus().isNotFound() //then
                .expectBody(ApiError.class)
                .value(apiError -> apiError.getCode(), equalTo(ErrorCode.REMOTE.getValue()));
    }
}
