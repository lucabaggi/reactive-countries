package it.lucabaggi.countries.controller;

import it.lucabaggi.countries.model.Country;
import it.lucabaggi.countries.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;

@CrossOrigin
@RestController
@RequestMapping("/countries")
public class CountryController {

    private CountryService countryService;

    @Autowired
    public CountryController(CountryService countryService) {
        this.countryService = countryService;
    }

    @GetMapping(value = "/{name}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Flux<Country>> getCountries(@PathVariable("name") String name) {
        return ResponseEntity.ok().body(countryService.getCountries(name));
    }
}
