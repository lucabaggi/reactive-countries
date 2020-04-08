package it.lucabaggi.countries.unit;

import it.lucabaggi.countries.common.RestCountriesWebClient;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.web.reactive.function.client.WebClient;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@DisplayName("Unit tests for RestCountriesWebClient")
public class RestCountriesWebClientTest {

    private static final String A_BASE_URL = "http://localhost:8080";

    //sut
    private RestCountriesWebClient restCountriesWebClient = new RestCountriesWebClient(A_BASE_URL);

    @Test
    public void shouldBuildWebClient() {
        WebClient webClient = restCountriesWebClient.webClient();
        assertNotNull(webClient);
    }

}
