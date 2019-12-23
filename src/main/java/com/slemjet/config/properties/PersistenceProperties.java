package com.slemjet.config.properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource("classpath:db.properties")
public class PersistenceProperties {

    public final DataSource datasource;

    public final EntityManager entityManager;

    public PersistenceProperties(DataSource datasource, EntityManager entityManager) {
        this.datasource = datasource;
        this.entityManager = entityManager;
    }

    @Component
    public static class DataSource {
        @Value("${driver.classname}")
        public String driverClassName;

        @Value("${db.url}")
        public String url;

        @Value("${db.username}")
        public String username;

        @Value("${db.password}")
        public String password;

        @Value("${db.serverTimezone}")
        public String serverTimezone;
    }

    @Component
    public static class EntityManager {
        @Value("${em.hibernate.dialect}")
        public String hibernateDialect;

        @Value("${em.hibernate.hbm2ddl.auto}")
        public String hibernateHbm2ddl;

        @Value("${em.hibernate.show_sql}")
        public String hibernateShowSql;
    }
}
