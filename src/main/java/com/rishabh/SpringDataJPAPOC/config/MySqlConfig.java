package com.rishabh.SpringDataJPAPOC.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

@Configuration
@EnableJpaRepositories(
        basePackages = "com.rishabh.SpringDataJPAPOC.repository.customer",
        entityManagerFactoryRef = "entityManager",
        transactionManagerRef = "transactionManager")
public class MySqlConfig {

    @Bean
    @Primary
    public LocalContainerEntityManagerFactoryBean entityManager(EntityManagerFactoryBuilder em) {

        Map<String, Object> properties = new HashMap<>();
        properties.put("hibernate.dialect", "org.hibernate.dialect.MySQL5InnoDBDialect");
        return em.dataSource(mysqlDataSource())
                .packages("com.rishabh.SpringDataJPAPOC.model.customer")
                .properties(properties)
                .build();
    }

    @Primary
    @Bean
    public DataSource mysqlDataSource() {

        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/newdb");
        dataSource.setUsername("root");
        dataSource.setPassword("password");
        return dataSource;
    }

    @Primary
    @Bean
    public PlatformTransactionManager transactionManager(@Qualifier("entityManager") EntityManagerFactory entityManagerFactory) {

        return new JpaTransactionManager(entityManagerFactory);
    }
}

