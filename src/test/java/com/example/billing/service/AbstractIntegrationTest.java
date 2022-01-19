package com.example.billing.service;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.util.TestPropertyValues;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testcontainers.containers.GenericContainer;

@ActiveProfiles("test")
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = BillingServiceApplication.class)
@ContextConfiguration(initializers = AbstractIntegrationTest.Initializer.class)
public class AbstractIntegrationTest extends AbstractTestNGSpringContextTests {

    private static GenericContainer postgres = new GenericContainer("postgres:13.4")
            .withExposedPorts(5432)
            .withEnv("POSTGRES_DB", "billings")
            .withEnv("POSTGRES_USER", "postgres")
            .withEnv("POSTGRES_PASSWORD", "password");

    public static class Initializer implements ApplicationContextInitializer<ConfigurableApplicationContext> {
        private static final String JDBC_URL =
                String.format("jdbc:postgresql://%s:%d/ib?currentSchema=billings", postgres.getContainerIpAddress(), postgres.getFirstMappedPort());

        @Override
        public void initialize(ConfigurableApplicationContext context) {
            TestPropertyValues.of(springApplicationProperties())
                    .applyTo(context.getEnvironment(), TestPropertyValues.Type.SYSTEM_ENVIRONMENT, "testcontainers");
        }

        private static String[] springApplicationProperties() {
            return new String[]{
                    "spring.datasource.url=" + JDBC_URL,
                    "spring.datasource.username=postgres",
                    "spring.datasource.password=password",
                    "spring.liquibase.enabled=true",
                    "spring.liquibase.url=" + JDBC_URL
            };
        }
    }
}
