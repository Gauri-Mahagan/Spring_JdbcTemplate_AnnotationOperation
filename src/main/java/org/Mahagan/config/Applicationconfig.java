package org.Mahagan.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
@ComponentScan("org.Mahagan")
@PropertySource("classpath:application.properties")


public class Applicationconfig {
    @Autowired
    Environment environment;
    private final String URL="url";
    private final String USERNAME="user";
    private final String PASSWORD="password";
    private final String DRIVER="driver";



    @Bean
    DataSource dataSource(){

        DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
        driverManagerDataSource.setUrl(environment.getProperty(URL));
        driverManagerDataSource.setUsername(environment.getProperty(USERNAME));
        driverManagerDataSource.setPassword(environment.getProperty(PASSWORD));
        driverManagerDataSource.setDriverClassName(environment.getProperty(DRIVER));



        return driverManagerDataSource;

    }



}
