package ar.edu.unq.sarmiento.hibernate;

import java.util.EnumSet;

import org.hibernate.boot.spi.MetadataImplementor;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.hibernate.tool.schema.TargetType;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class SchemaFileDumper {

	private void writeToFile(String filePath) {
		new SchemaExport()
			.setOutputFile(filePath)
			.create(EnumSet.of(TargetType.SCRIPT), (MetadataImplementor) HibernateInfoHolder.getMetadata());
	}

	public static void main(String[] args) throws ClassNotFoundException {
		HibernateConf.modo = "generate";
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
		ctx.scan("ar.edu.unq.sarmiento", "ar.edu.unq.sarmiento.hibernate");
		ctx.refresh();

		SchemaFileDumper dumper = (SchemaFileDumper) ctx.getBean("schemaFileDumper");
		dumper.writeToFile("schema.sql");

		ctx.close();
	}
}