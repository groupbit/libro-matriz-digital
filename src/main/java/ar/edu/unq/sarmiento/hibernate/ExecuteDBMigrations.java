package ar.edu.unq.sarmiento.hibernate;

import org.flywaydb.core.Flyway;

public class ExecuteDBMigrations {
	public static void main(String[] args) {
		Flyway flyway = Flyway.configure().dataSource(
				"jdbc:mysql://localhost:3306/libroMatrizDigital", 
				"root", 
				"root").load();
		flyway.migrate();
	}
}
