package com.example.billing.service.utils;

import lombok.experimental.UtilityClass;
import org.springframework.boot.test.util.TestPropertyValues;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.testcontainers.containers.PostgreSQLContainer;

@UtilityClass
public class Postgres {
    public static final PostgreSQLContainer postgresqlContainer = new PostgreSQLContainer("postgres:13.4");

    public static class Initializer implements ApplicationContextInitializer<ConfigurableApplicationContext> {

        @Override
        public void initialize(ConfigurableApplicationContext applicationContext) {
            TestPropertyValues.of("spring.datasource.url" + postgresqlContainer.getJdbcUrl(),
                    "spring.datasource.username" + postgresqlContainer.getUsername(),
                    "spring.datasource.password" + postgresqlContainer.getPassword()).applyTo(applicationContext);
        }
    }
}
