package com.colak.springbeanpostprocessortutorial.databaseconnectorconfig;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class DatabaseConnectorConfigTest {
    @Autowired
    private ApplicationContext context;

    @Test
    void whenContextLoads_thenRegisterBeansDynamically() {
        DatabaseConnector sqlConnector = (DatabaseConnector) context.getBean("dbConnector_SQL");
        assertEquals("Database Type: SQL, Connection String: jdbc:sqlserver://example:1433", sqlConnector.getDatabaseDetails());

        DatabaseConnector mongoConnector = (DatabaseConnector) context.getBean("dbConnector_MongoDB");
        assertEquals("Database Type: MongoDB, Connection String: mongodb://example:27017", mongoConnector.getDatabaseDetails());
    }
}
