package com.julioluis.libraryapi.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
public class DataSourceConfig {

    @Autowired
    private Environment environment;

    @Bean
    public DataSource getDataSource() {
        DriverManagerDataSource managerDataSource=new DriverManagerDataSource();
        managerDataSource.setUrl(environment.getProperty("dev.url"));
        managerDataSource.setUsername(environment.getProperty("dev.username"));
        managerDataSource.setPassword(environment.getProperty("dev.password"));

        return managerDataSource;
    }

}
