package ar.edu.unq.sarmiento.hibernate.migrations;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

import ar.edu.unq.sarmiento.hibernate.HibernateConf;
import ar.edu.unq.sarmiento.hibernate.HibernateConf.HibernateMode;

@Component
public class DumpSQLSchema {
	public static void main(String[] args) throws ClassNotFoundException {
		HibernateConf.modo = HibernateMode.MIGRATION;
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
		ctx.scan("ar.edu.unq.sarmiento", "ar.edu.unq.sarmiento.hibernate");
		ctx.refresh();

		FlywayUtils.dumpSQLSchema();

		ctx.close();
	}
}