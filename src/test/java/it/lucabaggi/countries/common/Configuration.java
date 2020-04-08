package it.lucabaggi.countries.common;

public class Configuration {

    public static final int MOCK_SERVER_PORT = 9090;

    public static final String REMOTE_COUNTRIES_BASE_URI = "/rest/v2";
    public static final String REMOTE_COUNTRIES_BY_NAME_URI = REMOTE_COUNTRIES_BASE_URI + "/name/%s";
    public static final String COUNTRY_LIST_FILE_PATH = "country_list.json";

    public static final String COUNTRIES_ENDPOINT_URI = "/countries/%s";
}
