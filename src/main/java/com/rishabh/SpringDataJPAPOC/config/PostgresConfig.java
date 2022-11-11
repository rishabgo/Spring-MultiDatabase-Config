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
        basePackages = "com.rishabh.SpringDataJPAPOC.repository.product",
        entityManagerFactoryRef = "postgresEntityManager",
        transactionManagerRef = "postgresTransactionManager")
public class PostgresConfig {

    @Bean
    public LocalContainerEntityManagerFactoryBean postgresEntityManager(final EntityManagerFactoryBuilder em) {

        Map<String, Object> properties = new HashMap<>();
        properties.put("hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect");
        return em.dataSource(postgresDataSource())
                .packages("com.rishabh.SpringDataJPAPOC.model.product")
                .properties(properties)
                .build();
    }

    @Bean
    public DataSource postgresDataSource() {

        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("org.postgresql.Driver");
        dataSource.setUrl("jdbc:postgresql://localhost:5432/product");
        dataSource.setUsername("postgres");
        dataSource.setPassword("pasword");
        return dataSource;
    }

    @Bean
    public PlatformTransactionManager postgresTransactionManager(@Qualifier("postgresEntityManager") EntityManagerFactory entityManagerFactory) {

        return new JpaTransactionManager(entityManagerFactory);
    }

}
