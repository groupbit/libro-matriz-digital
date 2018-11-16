package ar.edu.unq.sarmiento.hibernate;

import java.util.Optional;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@Configuration
@ComponentScan(basePackages = "ar.edu.unq.sarmiento")
@EnableTransactionManagement
public class HibernateConf {
	public static String modo = "server";

	@Bean
	public LocalSessionFactoryBean sessionFactory() {
		LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
		sessionFactory.setDataSource(dataSource());
		sessionFactory.setPackagesToScan(new String[] { "ar.edu.unq.sarmiento.modelo" });
		sessionFactory.setHibernateProperties(hibernateProperties());
		

		return sessionFactory;
	}

	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		
		String host = readFromEnvVariable("M2_HOME", "localhost");
		String port = readFromEnvVariable("JAVA_HOME", "3306");
		String dbName = readFromEnvVariable("RDS_DB_NAME", "libroMatrizDigital");
		dataSource.setUrl("jdbc:mysql://" + host + ":" + port + "/" + dbName);
		dataSource.setUsername(readFromEnvVariable("RDS_USERNAME", "root"));
		String password = readFromEnvVariable("RDS_PASSWORD", "root");
		Logger.getAnonymousLogger().log(Level.WARNING, "El password es " + password);
		dataSource.setPassword(password);

		return dataSource;
	}

	@Bean
	@Autowired
	public PlatformTransactionManager hibernateTransactionManager(SessionFactory sessionFactory) {
		HibernateTransactionManager transactionManager = new HibernateTransactionManager();
		transactionManager.setSessionFactory(sessionFactory);
		return transactionManager;
	}
	
	private String readFromEnvVariable(String key, String defaultValue) {
		String getenv = System.getProperty("env_name");
		return Optional.ofNullable(getenv).orElse(defaultValue);
	}

	private final Properties hibernateProperties() {
		Properties hibernateProperties = new Properties();
		hibernateProperties.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL5InnoDBDialect");
		hibernateProperties.setProperty("cache.provider_class", "org.hibernate.cache.internal.NoCacheProvider");
		hibernateProperties.setProperty("show_sql", "true");
		if(HibernateConf.modo.equals("server")){
			hibernateProperties.setProperty("hibernate.hbm2ddl.auto", "update");
		}else{
			hibernateProperties.setProperty("hibernate.hbm2ddl.auto", "create");
			hibernateProperties.setProperty("hibernate.current_session_context_class", "thread");
		}
		return hibernateProperties;
	}
}
