package com.epam.esm.config.profile;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.*;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

@Configuration
@ComponentScan("com.epam.esm")
@Profile("prod")
@PropertySource("classpath:database.properties")
public class ProdConfig {

    private static final String DB_DRIVER = "db.driver";
    private static final String DB_URL = "db.url";
    private static final String DB_USER_NAME = "user";
    private static final String DB_PASSWORD = "password";
    private static final String INIT_POOL_SIZE = "initialSize";

    private final Environment environment;

    @Autowired
    public ProdConfig(Environment environment) {
        this.environment = environment;
    }

    @Bean
    public DataSource dateSource() {
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName(DB_DRIVER);
        dataSource.setUrl(DB_URL);
        dataSource.setUsername(DB_USER_NAME);
        dataSource.setPassword(DB_PASSWORD);
        dataSource.setInitialSize(Integer.parseInt(environment.getProperty(INIT_POOL_SIZE)));
        return dataSource;
    }

    @Bean
    public JdbcTemplate jdbcTemplate() {
        return new JdbcTemplate(dateSource());
    }
}
