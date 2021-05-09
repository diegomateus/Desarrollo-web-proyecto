package com.javeriana.web.project.Shared.Infrastructure.Hibernate;

import org.apache.tomcat.dbcp.dbcp2.BasicDataSource;
import org.hibernate.cfg.AvailableSettings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.io.FileSystemResource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import javax.sql.DataSource;
import java.util.Properties;

@Configuration
public class HibernateConfigFactory {

    @Autowired
    private Environment env;

    @Bean("session-factory")
    public LocalSessionFactoryBean sessionFactory()
    {
        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
        sessionFactory.setDataSource(dataSource());
        sessionFactory.setHibernateProperties(hibernateProperties());

        FileSystemResource resource1 = new FileSystemResource("./src/main/java/com/javeriana/web/project/Employees/Employee/Infrastructure/Hibernate/Employee.hbm.xml");
        FileSystemResource resource2 = new FileSystemResource("./src/main/java/com/javeriana/web/project/Properties/Property/Infrastructure/hibernate/Property.hbm.xml");
        FileSystemResource resource3 = new FileSystemResource("./src/main/java/com/javeriana/web/project/Properties/Offer/Infrastructure/Hibernate/Offer.hbm.xml");
        FileSystemResource resource4 = new FileSystemResource("./src/main/java/com/javeriana/web/project/Appointments/Appointment/Infrastructure/Hibernate/Appointment.hbm.xml");
        FileSystemResource resource5 = new FileSystemResource("./src/main/java/com/javeriana/web/project/Questions/Question/Infrastructure/Hibernate/Question.hbm.xml");

        sessionFactory.setMappingLocations(resource1,resource2, resource3, resource4, resource5);
        return sessionFactory;
    }

    @Bean("transactional-manager")
    public PlatformTransactionManager hibernateTransactionManager()
    {
        HibernateTransactionManager transactionManager = new HibernateTransactionManager();
        transactionManager.setSessionFactory(sessionFactory().getObject());
        return transactionManager;
    }

    private DataSource dataSource() {
        String url = env.getProperty("spring.datasource.url");
        String userName = env.getProperty("spring.datasource.username");
        String password = env.getProperty("spring.datasource.password");

        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setUrl(url);
        dataSource.setUsername(userName);
        dataSource.setPassword(password);
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        return dataSource;
    }

    private Properties hibernateProperties() {
        Properties hibernateProperties = new Properties();
        hibernateProperties.put(AvailableSettings.HBM2DDL_AUTO, "none");
        hibernateProperties.put(AvailableSettings.SHOW_SQL, "false");
        hibernateProperties.put(AvailableSettings.DIALECT, "org.hibernate.dialect.MySQLDialect");
        return hibernateProperties;
    }
}