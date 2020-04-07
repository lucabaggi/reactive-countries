package it.lucabaggi.countries.unit;

import it.lucabaggi.countries.common.CountryExceptionHandler;
import it.lucabaggi.countries.model.ApiError;
import it.lucabaggi.countries.model.ErrorCode;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.reactive.function.client.WebClientResponseException;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Unit tests for CountryExceptionHandlerTest")
public class CountryExceptionHandlerTest {

    private static final String AN_EXCEPTION_MESSAGE = "An exception message";

    //sut
    private CountryExceptionHandler exceptionHandler = new CountryExceptionHandler();

    @Test
    public void shouldReturnRemoteApiError() {
        HttpStatus notFound = HttpStatus.NOT_FOUND;
        WebClientResponseException exception = new WebClientResponseException(AN_EXCEPTION_MESSAGE, notFound.value(),
                notFound.getReasonPhrase(), null, null, null);

        ResponseEntity<ApiError> errorResponse = exceptionHandler.handleWebException(exception);

        assertEquals(notFound, errorResponse.getStatusCode());
        assertEquals(ErrorCode.REMOTE.getValue(), errorResponse.getBody().getCode());
        assertEquals(AN_EXCEPTION_MESSAGE, errorResponse.getBody().getMessage());
    }

    @Test
    public void shouldReturnGenericError() {
        Exception exception = new Exception(AN_EXCEPTION_MESSAGE);

        ResponseEntity<ApiError> errorResponse = exceptionHandler.handleGenericException(exception);

        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, errorResponse.getStatusCode());
        assertEquals(ErrorCode.GENERIC.getValue(), errorResponse.getBody().getCode());
        assertEquals(AN_EXCEPTION_MESSAGE, errorResponse.getBody().getMessage());
    }
}
