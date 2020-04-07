package it.lucabaggi.countries.unit;

import it.lucabaggi.countries.repository.model.Country;
import it.lucabaggi.countries.repository.mapper.CountryMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static it.lucabaggi.countries.common.Utils.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

@DisplayName("Unit test for CountryMapper")
public class CountryMapperTest {

    @Test
    public void shouldMapRepoCountryToDomainCountry() {
        Country repoCountry = buildRepoCountry();
        it.lucabaggi.countries.model.Country domainCountry = CountryMapper.INSTANCE.toDomainCountry(repoCountry);

        assertEquals(A_COUNTRY_NAME, domainCountry.getName());
        assertEquals(A_COUNTRY_REGION, domainCountry.getRegion());
        assertEquals(A_COUNTRY_SUBREGION, domainCountry.getSubregion());
        assertEquals(A_COUNTRY_CAPITAL, domainCountry.getCapital());
        assertEquals(A_COUNTRY_POPULATION, domainCountry.getPopulation());
    }

    @Test
    public void shouldNotMapNullSource() {
        it.lucabaggi.countries.model.Country domainCountry = CountryMapper.INSTANCE.toDomainCountry(null);
        assertNull(domainCountry);
    }

    private Country buildRepoCountry() {
        Country country = new Country();
        country.setName(A_COUNTRY_NAME);
        country.setCapital(A_COUNTRY_CAPITAL);
        country.setRegion(A_COUNTRY_REGION);
        country.setSubregion(A_COUNTRY_SUBREGION);
        country.setPopulation(A_COUNTRY_POPULATION);
        return country;
    }
}
