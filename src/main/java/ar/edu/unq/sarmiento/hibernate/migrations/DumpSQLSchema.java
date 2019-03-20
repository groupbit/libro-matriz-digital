package ar.edu.unq.sarmiento.hibernate.migrations;

import java.io.File;
import java.util.EnumSet;

import org.hibernate.boot.spi.MetadataImplementor;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.hibernate.tool.schema.TargetType;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

import ar.edu.unq.sarmiento.hibernate.HibernateConf;

@Component
public class DumpSQLSchema {

	public void writeToFile(String filePath) {
		deleteFile(filePath);
		
		new SchemaExport()
			.setOutputFile(filePath)
			.create(EnumSet.of(TargetType.SCRIPT), (MetadataImplementor) HibernateInfoHolder.getMetadata());
	}

	private boolean deleteFile(String filePath) {
		return new File(filePath).delete();
	}

	public static void main(String[] args) throws ClassNotFoundException {
		HibernateConf.modo = "generate";
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
		ctx.scan("ar.edu.unq.sarmiento", "ar.edu.unq.sarmiento.hibernate");
		ctx.refresh();

		DumpSQLSchema dumper = (DumpSQLSchema) ctx.getBean("schemaFileDumper");
		dumper.writeToFile("src/main/resources/db/schema.sql");

		ctx.close();
	}
}