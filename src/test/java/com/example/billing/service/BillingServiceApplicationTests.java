//package com.example.billing.service;
//
//import com.example.billing.service.utils.Postgres;
//import org.junit.jupiter.api.BeforeAll;
//import org.junit.jupiter.api.Test;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.ActiveProfiles;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.transaction.annotation.Transactional;
//
//@SpringBootTest
//class BillingServiceApplicationTests {
//
//    @Test
//    void contextLoads() {
//    }
//
//    @ActiveProfiles("test")
//    @SpringBootTest
//    public abstract static class IntegrationTestBase {
//        @BeforeAll
//        static void init() {
//            Postgres.postgresqlContainer.start();
//        }
//    }
//}
