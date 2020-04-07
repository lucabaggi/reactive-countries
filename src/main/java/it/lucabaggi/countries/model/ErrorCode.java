package it.lucabaggi.countries.model;

public enum ErrorCode {

    GENERIC ("E:GENERIC"), REMOTE ("E:REMOTE_EXCEPTION");

    private String value;

    private ErrorCode(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}
