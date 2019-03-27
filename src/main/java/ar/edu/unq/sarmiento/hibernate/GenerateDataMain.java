package ar.edu.unq.sarmiento.hibernate;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import ar.edu.unq.sarmiento.hibernate.HibernateConf.HibernateMode;

public class GenerateDataMain {

	public static void main(String[] args) {
		HibernateConf.modo = HibernateMode.DATA_SEED;
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
		ctx.scan("ar.edu.unq.sarmiento", "ar.edu.unq.sarmiento.hibernate");
		ctx.refresh();
		DataGenerator dg = (DataGenerator) ctx.getBean("dataGenerator");
		dg.generate();
		
		ctx.close();
	}

}
