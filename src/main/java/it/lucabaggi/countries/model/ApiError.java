package it.lucabaggi.countries.model;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class ApiError {

    private String code;
    private String message;

}
