package it.lucabaggi.countries.common;

import it.lucabaggi.countries.model.Country;

public class Utils {

    public static final String A_COUNTRY_NAME = "Italy";
    public static final String A_COUNTRY_CAPITAL = "Rome";
    public static final String A_COUNTRY_REGION = "Europe";
    public static final String A_COUNTRY_SUBREGION = "Southern Europe";
    public static final Long A_COUNTRY_POPULATION = 60665551L;

    public static Country buildCountry() {
        return Country.builder()
                .name(A_COUNTRY_NAME)
                .capital(A_COUNTRY_CAPITAL)
                .region(A_COUNTRY_REGION)
                .subregion(A_COUNTRY_SUBREGION)
                .population(A_COUNTRY_POPULATION)
                .build();
    }
}
