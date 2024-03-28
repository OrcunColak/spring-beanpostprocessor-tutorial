package com.colak.springbeanpostprocessortutorial.databaseconnectorconfig;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DatabaseConnector {
    private String type;
    private String connectionString;

    public String getDatabaseDetails() {
        return "Database Type: " + type + ", Connection String: " + connectionString;
    }
}
