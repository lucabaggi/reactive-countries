package it.lucabaggi.countries.common;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

@Component
public class RestCountriesWebClient {

    @Value( "${rest_countries.base_url}" )
    private String restCountriesBaseUrl;

    @Bean
    public WebClient webClient() {
        return WebClient.builder()
                .baseUrl(restCountriesBaseUrl)
                .build();
    }
}
