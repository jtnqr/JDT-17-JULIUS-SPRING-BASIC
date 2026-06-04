package com.inidivaragroup.jdt17.spring.dasar.example.configuration;

public class DatabaseConfiguration {
    public static DatabaseConfiguration databaseConfiguration;

    public DatabaseConfiguration() {}

    public static DatabaseConfiguration getInstance() {
        if (databaseConfiguration == null) {
            databaseConfiguration = new DatabaseConfiguration();
        }

        return databaseConfiguration;
    }
}
