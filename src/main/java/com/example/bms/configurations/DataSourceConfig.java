package com.example.bms.configurations;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
@MapperScan({"com.example.bms.repositories"})
public class DataSourceConfig {

    @Bean
//    @Profile("pgsql")
    public DataSource dataSource(){
        DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
        driverManagerDataSource.setDriverClassName("org.postgresql.Driver");
        driverManagerDataSource.setUrl("jdbc:postgresql://35.247.143.236:5432/spring_bmsdb");
        driverManagerDataSource.setUsername("db_user");
        driverManagerDataSource.setPassword("IT@$PringPr0j%c!");

        return driverManagerDataSource;
    }

    @Bean
    public DataSourceTransactionManager dataSourceTransactionManager(){
        return new DataSourceTransactionManager(dataSource());
    }
}
