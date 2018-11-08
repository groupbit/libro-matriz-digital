package ar.edu.unq.sarmiento.hibernate;

import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unq.sarmiento.modelo.Alumno;
import ar.edu.unq.sarmiento.modelo.Carrera;

@Component
@Transactional
public class DataGenerator {

	@Autowired
	private AlumnoHome alumnoHome;
	@Autowired
	private SessionFactory sessionFactory;
	@Autowired 
	private CarreraHome carreraHome;
	
	
	protected void generate() {
		
		Alumno alumno = new Alumno();
		alumno.setNombre("Juan");
		
		Carrera carrera1 = new Carrera();
		carrera1.setNombre("Profesorado de Matemáticas");
		
		Carrera carrera2 = new Carrera();
		carrera2.setNombre("Técnicatura en programación informática");
		
		Transaction ts = sessionFactory.getCurrentSession().beginTransaction();
		alumnoHome.saveOrUpdate(alumno);
		carreraHome.saveOrUpdate(carrera2);
		carreraHome.saveOrUpdate(carrera1);
		
		ts.commit();
	}
}
