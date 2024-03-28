package com.colak.springtutorial.dynamicbeanregistration.databaseconnectorconfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

@Configuration
public class DatabaseConnectorConfig {

    @Bean
    DatabaseConnectorRegistryPostProcessor databaseConnectorRegistryPostProcessor(Environment environment) {
        return new DatabaseConnectorRegistryPostProcessor(environment);
    }
}
