package it.lucabaggi.countries.unit;

import it.lucabaggi.countries.controller.CountryController;
import it.lucabaggi.countries.model.Country;
import it.lucabaggi.countries.service.CountryService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

import static it.lucabaggi.countries.common.Utils.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
@DisplayName("Unit tests for CountryController")
public class CountryControllerTest {

    @Mock
    private CountryService countryService;

    //sut
    @InjectMocks
    private CountryController countryController;

    @Test
    public void shouldReturnOkResponseWithBody() {
        final String countrySearchName = "italy";
        Flux<Country> countryFlux = Flux.just(buildCountry());
        Mockito.when(countryService.getCountries(countrySearchName)).thenReturn(countryFlux);

        ResponseEntity<Flux<Country>> httpResponse = countryController.getCountries(countrySearchName);

        assertEquals(HttpStatus.OK, httpResponse.getStatusCode());
        StepVerifier.create(httpResponse.getBody())
                .expectNext(buildCountry())
                .verifyComplete();
    }

}
