package ar.edu.unq.sarmiento.hibernate.migrations;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class CreateMigrationFile {
	public static void main(String[] args) {
		String dateTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss"));
		String migrationFileName = "V" + dateTime + "__Completar_descripcion.sql";
		String migrationsFolder = "src/main/resources/db/migration";
		try {
			new File(migrationsFolder + "/" + migrationFileName).createNewFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
