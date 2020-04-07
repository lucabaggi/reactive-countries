
package it.lucabaggi.countries.repository.model;

import lombok.*;

@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Currency {

    private String code;
    private String name;
    private String symbol;

}
