package ar.edu.unq.sarmiento.hibernate.migrations;

import javax.sql.DataSource;

import org.flywaydb.core.Flyway;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import ar.edu.unq.sarmiento.hibernate.HibernateConf;

public class RunFlywayDBMigrations {

	public static void main(String[] args) {
		HibernateConf.modo = "migrate";
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
		ctx.scan("ar.edu.unq.sarmiento", "ar.edu.unq.sarmiento.hibernate");
		ctx.refresh();
		
		DataSource dataSource = (DataSource) ctx.getBean("dataSource");
		Flyway flyway = Flyway.configure().dataSource(dataSource).load();
		flyway.migrate();
		
		ctx.close();
	}
}
