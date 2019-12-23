package com.slemjet.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@Import({PersistenceConfig.class})
@EnableTransactionManagement
public class AppConfig {


}
