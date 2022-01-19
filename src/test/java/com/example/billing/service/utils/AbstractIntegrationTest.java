package com.example.billing.service.utils;

import com.example.billing.service.BillingServiceApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.util.TestPropertyValues;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testcontainers.containers.GenericContainer;
import org.testcontainers.junit.jupiter.Container;

@ActiveProfiles("test")
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = BillingServiceApplication.class)
@ContextConfiguration(initializers = AbstractIntegrationTest.Initializer.class)
public class AbstractIntegrationTest extends AbstractTestNGSpringContextTests {

    @Container
    private static GenericContainer<?> postgres = new GenericContainer<>("postgres:13.4")
            .withExposedPorts(5432)
            .withEnv("POSTGRES_DB", "billings_test")
            .withEnv("POSTGRES_USER", "postgres")
            .withEnv("POSTGRES_PASSWORD", "password");

    static {
        postgres.start();
    }

    public static class Initializer implements ApplicationContextInitializer<ConfigurableApplicationContext> {
        @Override
        public void initialize(ConfigurableApplicationContext context) {
            TestPropertyValues.of(
                            "spring.datasource.url=" + String.format(
                                    "jdbc:postgresql://%s:%d/billings_test",
                                    postgres.getContainerIpAddress(),
                                    postgres.getFirstMappedPort()),
                            "spring.datasource.username=postgres",
                            "spring.datasource.password=password"
                    )
                    .applyTo(context.getEnvironment(), TestPropertyValues.Type.SYSTEM_ENVIRONMENT, "testcontainers");
        }
    }
}
