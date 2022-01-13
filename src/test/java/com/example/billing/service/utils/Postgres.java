package com.example.billing.service.utils;

import lombok.experimental.UtilityClass;
import org.springframework.boot.test.util.TestPropertyValues;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.testcontainers.containers.GenericContainer;
import org.testcontainers.containers.PostgreSQLContainer;

@UtilityClass
public class Postgres {
    public static final GenericContainer postgresqlContainer = new GenericContainer("postgres:13.4")
            .withExposedPorts(5432)
            .withEnv("POSTGRES_DB", "BILL")
            .withEnv("POSTGRES_USER", "postgres");

//    public static class Initializer implements ApplicationContextInitializer<ConfigurableApplicationContext> {
//
//        @Override
//        public void initialize(ConfigurableApplicationContext applicationContext) {
//            TestPropertyValues.of("spring.datasource.url" + postgresqlContainer.getJdbcUrl(),
//                    "spring.datasource.username" + postgresqlContainer.getUsername(),
//                    "spring.datasource.password" + postgresqlContainer.getPassword()).applyTo(applicationContext);
//        }
//    }
}
