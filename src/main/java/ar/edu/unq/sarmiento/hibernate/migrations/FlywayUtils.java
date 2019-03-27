package ar.edu.unq.sarmiento.hibernate.migrations;

import java.io.File;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.EnumSet;

import org.hibernate.boot.spi.MetadataImplementor;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.hibernate.tool.schema.TargetType;

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
	
	static void dumpSQLSchema() {
		deleteFile(sqlSchemaFile());
		
		new SchemaExport()
			.setOutputFile(sqlSchemaFile())
			.create(EnumSet.of(TargetType.SCRIPT), (MetadataImplementor) HibernateInfoHolder.getMetadata());
	}
	
	static void deleteFile(String filePath) {
		new File(filePath).delete();
	}
}
