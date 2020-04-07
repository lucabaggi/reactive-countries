
package it.lucabaggi.countries.repository.model;

import lombok.*;

import java.util.List;

@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class RegionalBloc {

    private String acronym;
    private String name;
    private List<Object> otherAcronyms = null;
    private List<Object> otherNames = null;

}
