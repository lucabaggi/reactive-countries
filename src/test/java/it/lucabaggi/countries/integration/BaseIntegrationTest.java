package it.lucabaggi.countries.integration;

import com.github.tomakehurst.wiremock.WireMockServer;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static com.github.tomakehurst.wiremock.core.WireMockConfiguration.options;
import static it.lucabaggi.countries.common.Configuration.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@ActiveProfiles("test")
public class BaseIntegrationTest {

    protected static WireMockServer mockServer;

    @BeforeAll
    public static void setUp() {
        mockServer = new WireMockServer(options().port(MOCK_SERVER_PORT));
        mockServer.start();
    }

    @AfterAll
    public static void tearDown() {
        mockServer.stop();
    }

    @BeforeEach
    public void reset() {
        mockServer.resetAll();
    }

    protected void stubPositiveResponse(String countrySearchText) {
        mockServer.stubFor(get(urlPathMatching(String.format(REMOTE_COUNTRIES_BY_NAME_URI, countrySearchText)))
                .willReturn(ok().withHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_UTF8_VALUE)
                        .withBodyFile(COUNTRY_LIST_FILE_PATH)));
    }

    protected void stubNotFoundResponse(String countrySearchText) {
        mockServer.stubFor(get(urlPathMatching(String.format(REMOTE_COUNTRIES_BY_NAME_URI, countrySearchText)))
                .willReturn(notFound()));
    }
}
