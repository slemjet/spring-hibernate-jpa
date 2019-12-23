package com.slemjet.config;

import com.slemjet.config.properties.PersistenceProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Properties;

@Configuration
public class PersistenceConfig {

    public static final String ENTITY_ROOT_PACKAGE = "com.slemjet.entity";
    public static final String PERSISTENCE_UNIT_NAME = "myPersistenceUnit";

    private PersistenceProperties properties;

    public PersistenceConfig(PersistenceProperties properties) {
        this.properties = properties;
    }

    @Bean
    public DataSource myDataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();

        dataSource.setDriverClassName(properties.datasource.driverClassName);
        dataSource.setUrl(properties.datasource.url);
        dataSource.setUsername(properties.datasource.username);
        dataSource.setPassword(properties.datasource.password);
        dataSource.setConnectionProperties(new Properties() {{
            put("serverTimezone", properties.datasource.serverTimezone);
        }});
        return dataSource;
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean myEntityManager() {
        LocalContainerEntityManagerFactoryBean factoryBean = new LocalContainerEntityManagerFactoryBean();

        factoryBean.setDataSource(myDataSource());
        factoryBean.setPackagesToScan(ENTITY_ROOT_PACKAGE);
        factoryBean.setPersistenceUnitName(PERSISTENCE_UNIT_NAME);

        factoryBean.setJpaPropertyMap(new HashMap<String, String>() {{
            put("hibernate.dialect", properties.entityManager.hibernateDialect);
            put("hibernate.hbm2ddl.auto", properties.entityManager.hibernateHbm2ddl);
            put("hibernate.show_sql", properties.entityManager.hibernateShowSql);
        }});

        JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        factoryBean.setJpaVendorAdapter(vendorAdapter);

        return factoryBean;
    }

    @Bean
    public PlatformTransactionManager myTransactionManager(EntityManagerFactory emf) {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(emf);

        return transactionManager;
    }

    @Bean
    public PersistenceExceptionTranslationPostProcessor exceptionTranslation() {
        return new PersistenceExceptionTranslationPostProcessor();
    }
}
