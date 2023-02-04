package com.l3r8y.axiotesttask.config;

import org.apache.tomcat.dbcp.dbcp2.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@ComponentScan(basePackages = "com.l3r8y.axiotesttask")
@EnableTransactionManagement
@PropertySource("classpath:application.properties")
public class HibernateConfig {

    @Bean
    public LocalSessionFactoryBean sessionFactory() {
        final LocalSessionFactoryBean factory = new LocalSessionFactoryBean();
        factory.setDataSource(this.dataSource());
        factory.setPackagesToScan("com.l3r8y.axiotesttask");
        factory.setHibernateProperties(this.hibernateProperties());
        return factory;
    }

    @Bean
    public DataSource dataSource() {
        final BasicDataSource source = new BasicDataSource();
        // sensitive data mustn't be here
        source.setDriverClassName("org.postgresql.Driver");
        source.setUrl("jdbc:postgresql://127.0.0.1:5432/postgres");
        source.setUsername("postgres");
        source.setPassword("root");
        return source;
    }

    @Bean
    public PlatformTransactionManager hibernateTransactionManager() {
        final HibernateTransactionManager manager = new HibernateTransactionManager();
        manager.setSessionFactory(this.sessionFactory().getObject());
        return manager;
    }

    private Properties hibernateProperties() {
        final Properties properties = new Properties();
        properties.setProperty("hibernate.hbm2ddl.auto", "update");
        properties.setProperty("hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect");
        properties.setProperty("hibernate.enable_lazy_load_no_trans", "true");
        return properties;
    }
}
