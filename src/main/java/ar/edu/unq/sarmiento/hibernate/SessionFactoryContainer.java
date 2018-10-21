package ar.edu.unq.sarmiento.hibernate;

import java.util.EnumSet;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.hibernate.tool.schema.TargetType;

public class SessionFactoryContainer {

	private static SessionFactory sessionFactory;

	public static synchronized SessionFactory getSessionFactory() {
		if (sessionFactory == null) {
			buildSessionFactory(false);
		}
		return sessionFactory;
	}

	public synchronized static void buildSessionFactory(boolean generateSchema) {
		final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
				.configure().build();

		try {
			Metadata metadata = new MetadataSources(registry).buildMetadata();

			generateSchema(generateSchema, metadata);
			sessionFactory = metadata.buildSessionFactory();
		} catch (RuntimeException e) {
			sessionFactory = null;
			StandardServiceRegistryBuilder.destroy(registry);
			throw e;
		}
	}

	private static void generateSchema(boolean generateSchema, Metadata metadata) {
		if (generateSchema) {
			SchemaExport schema = new SchemaExport();
			schema.create(EnumSet.of(TargetType.DATABASE), metadata);
		}
	}
}


