package it.lucabaggi.countries.unit;

import it.lucabaggi.countries.model.Country;
import it.lucabaggi.countries.repository.CountryRepository;
import it.lucabaggi.countries.service.CountryServiceImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

import static it.lucabaggi.countries.common.Utils.buildCountry;

@ExtendWith(MockitoExtension.class)
@DisplayName("Unit tests for CountryService")
public class CountryServiceTest {

    @Mock
    private CountryRepository countryRepository;

    //sut
    @InjectMocks
    private CountryServiceImpl countryService;

    @Test
    public void shouldReturnCountryList() {
        final String countrySearchName = "italy";
        Flux<Country> countryFlux = Flux.just(buildCountry());
        Mockito.when(countryRepository.getCountries(countrySearchName)).thenReturn(countryFlux);

        Flux<Country> result = countryService.getCountries(countrySearchName);

        StepVerifier.create(result)
                .expectNext(buildCountry())
                .verifyComplete();

    }

}
