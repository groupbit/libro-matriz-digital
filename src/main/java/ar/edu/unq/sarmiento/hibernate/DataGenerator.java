package ar.edu.unq.sarmiento.hibernate;

import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unq.sarmiento.modelo.Alumno;

@Component
@Transactional
public class DataGenerator {

	@Autowired
	private Home<Alumno> alumnoHome;
	@Autowired
	private SessionFactory sessionFactory;
	
	protected void generate() {
//		Maguito harry = new Maguito("Harry", 100);
//		harry.addItem(new Item("varita", 1));
//		harry.addItem(new Item("capa", 3));
//		harry.setExperiencia(10);
//
//		Maguito gandalf = new Maguito("Gandalf", 90);
//		gandalf.addItem(new Item("baculo", 7));
//		gandalf.addItem(new Item("sombrero", 2));
//		gandalf.setExperiencia(200);
//
//		maguitoHome.saveOrUpdate(harry);
//		maguitoHome.saveOrUpdate(gandalf);
		
		Alumno alumno = new Alumno();
		alumno.setNombre("Juan");
		
		Transaction ts = sessionFactory.getCurrentSession().beginTransaction();
		alumnoHome.saveOrUpdate(alumno);
		ts.commit();
	}
}
