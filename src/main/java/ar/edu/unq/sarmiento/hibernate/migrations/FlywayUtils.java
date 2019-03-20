package ar.edu.unq.sarmiento.hibernate.migrations;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class FlywayUtils {
	static String BASE_PATH = "src/main/resources/db/";

	static String sqlSchemaFile() {
		return BASE_PATH + "schema.sql";
	}

	static String migrationsFolder() {
		return BASE_PATH + "migration/";
	}

	static String newMigrationFilename() {
		String dateTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss"));
		return migrationsFolder() + "V" + dateTime + "__Completar_descripcion.sql";
	}
}
