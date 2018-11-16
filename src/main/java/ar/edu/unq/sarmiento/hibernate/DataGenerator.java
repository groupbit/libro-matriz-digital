package ar.edu.unq.sarmiento.hibernate;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;

import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unq.sarmiento.modelo.Alumno;
import ar.edu.unq.sarmiento.modelo.Carrera;
import ar.edu.unq.sarmiento.modelo.Cursada;
import ar.edu.unq.sarmiento.modelo.Direccion;
import ar.edu.unq.sarmiento.modelo.Docente;
import ar.edu.unq.sarmiento.modelo.EstudioCursado;
import ar.edu.unq.sarmiento.modelo.Examen;
import ar.edu.unq.sarmiento.modelo.Materia;

@Component
@Transactional
public class DataGenerator {

	@Autowired
	private AlumnoHome alumnoHome;
	@Autowired
	private CarreraHome carreraHome;
	@Autowired
	private CursadaHome cursadaHome;
	@Autowired
	private DocenteHome docenteHome;
	@Autowired
	private ExamenHome examenHome;
	@Autowired
	private MateriaHome materiaHome;
	@Autowired
	private DireccionHome direccionHome;
	@Autowired
	private EstudioCursadoHome estudioCursadoHome;
	@Autowired
	private SessionFactory sessionFactory;
	
	
	protected void generate() {
		
		Alumno alumno = new Alumno();
		alumno.setNombre("Juan");
		
		Carrera carrera = new Carrera();
		carrera.setNombre("Programación informática");
		carrera.setDuracion(5);
		carrera.setResolucion("1280/52");
		
		Carrera carrera2 = new Carrera();
		carrera2.setNombre("Profesorado de Inglés");
		carrera2.setDuracion(4);
		carrera2.setResolucion("1805/17");
		
		Carrera carrera3 = new Carrera();
		carrera3.setNombre("Nivel inicial");
		carrera3.setDuracion(5);
		carrera3.setResolucion("5860/16");
		carrera3.setArchivada(true);
		
		
		
		Direccion direccion = new Direccion("Marmol", 855, null, "2752", "Capital Sarmiento");
		
		Docente docente = new Docente();
		docente.setNombre("Fede");
		
		Examen examen = new Examen();
		examen.setExamenFinal("Examen final");
		
		Materia materia = new Materia();
		materia.setNombre("Hibernate");
		
		Cursada cursada = new Cursada();
		cursada.setMateria(materia);
		
		EstudioCursado titulo= new EstudioCursado();
		titulo.setAnioEgreso(2016);
		alumno.setTitulo(titulo);
		
		Transaction ts = sessionFactory.getCurrentSession().beginTransaction();
		alumnoHome.saveOrUpdate(alumno);
		carreraHome.saveOrUpdate(carrera);
		docenteHome.saveOrUpdate(docente);
		examenHome.saveOrUpdate(examen);
		materiaHome.saveOrUpdate(materia);
		direccionHome.saveOrUpdate(direccion);
		cursadaHome.saveOrUpdate(cursada);
		estudioCursadoHome.saveOrUpdate(titulo);
		carreraHome.saveOrUpdate(carrera3);
		carreraHome.saveOrUpdate(carrera2);
		ts.commit();
	}
}
