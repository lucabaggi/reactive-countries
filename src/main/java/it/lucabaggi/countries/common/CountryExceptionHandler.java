package it.lucabaggi.countries.common;

import it.lucabaggi.countries.model.ApiError;
import it.lucabaggi.countries.model.ErrorCode;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.reactive.function.client.WebClientResponseException;

@ControllerAdvice
public class CountryExceptionHandler {

    @ExceptionHandler(value = {WebClientResponseException.class})
    public ResponseEntity<ApiError> handleWebException(WebClientResponseException ex) {
        ApiError errorBody = ApiError.builder()
                .code(ErrorCode.REMOTE.getValue())
                .message(ex.getLocalizedMessage())
                .build();

        return ResponseEntity.status(ex.getStatusCode()).body(errorBody);
    }

    @ExceptionHandler(value = {Exception.class})
    public ResponseEntity<ApiError> handleGenericException(Exception ex) {
        ApiError errorBody = ApiError.builder()
                .code(ErrorCode.GENERIC.getValue())
                .message(ex.getLocalizedMessage())
                .build();

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorBody);
    }
}
