package it.lucabaggi.countries.integration;

import it.lucabaggi.countries.common.MockServerBaseTest;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@ActiveProfiles("test")
public abstract class BaseIntegrationTest extends MockServerBaseTest {}
