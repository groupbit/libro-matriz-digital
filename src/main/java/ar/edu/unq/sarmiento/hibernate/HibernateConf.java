package ar.edu.unq.sarmiento.hibernate;

import java.io.Console;
import java.util.Optional;
import java.util.Properties;

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
	public enum HibernateMode {
		SERVER("validate"), 
		DATA_SEED("validate"), 
		MIGRATION("none");
		
		private String hbm2ddlMode;

		HibernateMode(String hbm2ddlMode) {
			this.hbm2ddlMode = hbm2ddlMode;
		}

		public String getHbm2ddlMode() {
			return hbm2ddlMode;
		}
	}
	
	public static HibernateMode modo = HibernateMode.SERVER;

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
		
		String host = readFromEnvVariable("DB_HOSTNAME", "localhost");
		String port = readFromEnvVariable("DB_PORT", "3306");
		dataSource.setUrl("jdbc:mysql://" + host + ":" + port + "/libroMatrizDigital");
		dataSource.setUsername(readFromEnvVariable("DB_USERNAME", "root"));
		dataSource.setPassword(readFromEnvVariable("DB_PASSWORD", "root"));

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
		return Optional
				.ofNullable(System.getenv(key))
				.orElse(defaultValue);
	}

	private final Properties hibernateProperties() {
		Properties hibernateProperties = new Properties();
		hibernateProperties.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL5InnoDBDialect");
		hibernateProperties.setProperty("cache.provider_class", "org.hibernate.cache.internal.NoCacheProvider");
		hibernateProperties.setProperty("show_sql", "true");
		
		hibernateProperties.setProperty("hibernate.hbm2ddl.auto", HibernateConf.modo.hbm2ddlMode);
		
		if (HibernateConf.modo == HibernateMode.DATA_SEED) {
			hibernateProperties.setProperty("hibernate.current_session_context_class", "thread");
		}
		
		return hibernateProperties;
	}
}
