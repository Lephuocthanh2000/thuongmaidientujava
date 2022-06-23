package com.ThanhLe.thuongmaidientu;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;

import javax.sql.DataSource;
import java.io.IOException;
import java.util.Properties;

@Configuration
//@PropertySource("application.yml")
@EnableConfigurationProperties
@ConfigurationProperties("datasource.yaml")
public class HibernateConfig {
    @Autowired
    Environment env;

    @Bean
    public DataSource getDataSource() {
        
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(env.getProperty("spring.datasource.driver-class-name","org.postgresql.Driver"));
        dataSource.setUrl(env.getProperty("spring.datasource.url","jdbc:postgresql://localhost:5432/thuongmaidientu"));
        dataSource.setUsername(env.getProperty("springdatasource.username","postgres"));
        dataSource.setPassword(env.getProperty("spring.datasource.password","123456"));
        return dataSource;
    }
    @Bean
    @Autowired
    public SessionFactory getSessionFactory(DataSource dataSource) throws IOException {
        LocalSessionFactoryBean factoryBean=new LocalSessionFactoryBean();
        factoryBean.setPackagesToScan(new String[] {"com/ThanhLe/thuongmaidientu/entity"});
        factoryBean.setDataSource(dataSource);
        Properties props=factoryBean.getHibernateProperties();
        props.put("hibernate.dialect", env.getProperty("spring.jpa.hibernate.dialect","org.hibernate.dialect.SQLServer2008Dialect"));
        props.put("hibernate.show_sql", env.getProperty("spring.jpa.show-sql","true"));
        props.put("current_session_context_class", env.getProperty("spring.jpa.session","org.springframework.orm.hibernate5.SpringSessionContext"));
        factoryBean.afterPropertiesSet();
        SessionFactory sessionFactory=factoryBean.getObject();
        return sessionFactory;
    }
    @Bean
    @Autowired
    public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory) {
        return new HibernateTransactionManager(sessionFactory);
    }
}
