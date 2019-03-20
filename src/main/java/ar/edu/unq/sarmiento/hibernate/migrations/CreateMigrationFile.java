package ar.edu.unq.sarmiento.hibernate.migrations;

import java.io.File;
import java.io.IOException;

public class CreateMigrationFile {
	public static void main(String[] args) {
		try {
			new File(FlywayUtils.newMigrationFilename()).createNewFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
