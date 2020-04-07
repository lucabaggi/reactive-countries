package it.lucabaggi.countries.model;

import lombok.*;

@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Country {

    private String name;
    private String capital;
    private String region;
    private String subregion;
    private Long population;

}
