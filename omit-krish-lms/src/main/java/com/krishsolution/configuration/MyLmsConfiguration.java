package com.krishsolution.configuration;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@EnableWebMvc
@Configuration
@ComponentScan(basePackages = { "com/*" })
@EnableTransactionManagement
public class MyLmsConfiguration {

	@Bean
	public ViewResolver viewResolver() {

		InternalResourceViewResolver internalResourceView = new InternalResourceViewResolver();
		internalResourceView.setPrefix("/WEB-INF/view/");
		internalResourceView.setSuffix(".jsp");

		return internalResourceView;
	}
//sessionfactory of session
	@Bean
	public LocalSessionFactoryBean localSessionFactoryBean() {

		LocalSessionFactoryBean localSessionFactoryBean = new LocalSessionFactoryBean();

		localSessionFactoryBean.setPackagesToScan("com.krishsolution.entity");
		localSessionFactoryBean.setDataSource(dataSource());

		localSessionFactoryBean.setHibernateProperties(getProperties());

		return localSessionFactoryBean;
	}

	@Bean
	public DataSource dataSource() {

		DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();

		driverManagerDataSource.setUsername("root");
		driverManagerDataSource.setPassword("1234");
//		jdbc:mysql://localhost:3306/?user=root
		driverManagerDataSource.setUrl("jdbc:mysql://localhost:3306/omit-krish-lms");
		driverManagerDataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
		return driverManagerDataSource;
	}

	public Properties getProperties() {

//		org.hibernate.dialect.MySQLDialect
		Properties hibernatePro = new Properties();
		hibernatePro.put("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
		hibernatePro.put("hibernate.show_sql", "true");
		hibernatePro.put("hibernate.format_sql", "true");
		hibernatePro.put("hibernate.hbm2ddl.auto", "update");
		return hibernatePro;

	}

	@Bean
	public HibernateTransactionManager getHibernateTransactionManager(SessionFactory sessionFactory) {

		return new HibernateTransactionManager(sessionFactory);
	}
}
