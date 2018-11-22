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
import ar.edu.unq.sarmiento.modelo.TipoDeExamen;

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
		alumno.setNombre("Juan Rodriguez");
		alumno.setEmail("juancito@gmail.com");
		alumno.setDni("25897542");
		alumno.setTelefono("2478558965");
		alumno.setDireccion(new Direccion("Calle falsa", 123, "", "2752", "Capitán Sarmiento"));
		
		Alumno alumno2 = new Alumno();
		alumno2.setNombre("Esteban Cufré");
		alumno2.setEmail("esteban@gmail.com");
		alumno2.setTelefono("2478547856");
		alumno2.setDni("15698544");
		alumno2.setDireccion(new Direccion("Rivadavia", 147, "", "2752", "Capitán Sarmiento"));
		
		Alumno alumno3 = new Alumno();
		alumno3.setNombre("Karina Rivarola");
		alumno3.setEmail("kari@gmail.com");
		alumno3.setTelefono("2478458796");
		alumno3.setDni("24587985");
		alumno3.setDireccion(new Direccion("Alem", 1123, "", "2752", "Capitán Sarmiento"));
		
		Carrera carrera = new Carrera();
		carrera.setNombre("Programación informática");
		
		Direccion direccion = new Direccion("Marmol", 855, null, "2752", "Capital Sarmiento");
		
		Docente docente = new Docente();
		docente.setNombre("Fede");
		docente.setApellido("Aloi");
		docente.setEmail("aloi@gmail.com");
		Examen examen = new Examen();
		examen.setTipoDeExamen(TipoDeExamen.FINAL);
		
		Materia materia = new Materia();
		materia.setNombre("Hibernate");
		
		materia.setCarrera(carrera);
		carrera.agregarMateria(materia);
		materia.setDocente(docente);
		materia.setAnioEnCarrera(5);
		materia.setEsPromocionable(true);
		
		Cursada cursada = new Cursada();
		cursada.setMateria(materia);
		
		EstudioCursado titulo= new EstudioCursado();
		titulo.setAnioEgreso(2016);
		alumno3.setTitulo(titulo);
		
		Transaction ts = sessionFactory.getCurrentSession().beginTransaction();
		alumnoHome.saveOrUpdate(alumno);
		alumnoHome.saveOrUpdate(alumno2);
		alumnoHome.saveOrUpdate(alumno3);
		carreraHome.saveOrUpdate(carrera);
		docenteHome.saveOrUpdate(docente);
		examenHome.saveOrUpdate(examen);
		materiaHome.saveOrUpdate(materia);
		direccionHome.saveOrUpdate(direccion);
		cursadaHome.saveOrUpdate(cursada);
		estudioCursadoHome.saveOrUpdate(titulo);
		
		ts.commit();
	}
}
