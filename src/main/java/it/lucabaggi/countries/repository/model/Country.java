
package it.lucabaggi.countries.repository.model;

import lombok.*;

import java.util.List;

@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Country {

    private String name;
    private List<String> topLevelDomain = null;
    private String alpha2Code;
    private String alpha3Code;
    private List<String> callingCodes = null;
    private String capital;
    private List<String> altSpellings = null;
    private String region;
    private String subregion;
    private Long population;
    private List<Double> latlng = null;
    private String demonym;
    private Double area;
    private Double gini;
    private List<String> timezones = null;
    private List<String> borders = null;
    private String nativeName;
    private String numericCode;
    private List<Currency> currencies = null;
    private List<Language> languages = null;
    private Translations translations;
    private String flag;
    private List<RegionalBloc> regionalBlocs = null;
    private String cioc;

}
