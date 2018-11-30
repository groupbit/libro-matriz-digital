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
		alumno.setNombre("Juan Rodriguez");
		alumno.setEmail("juancito@gmail.com");
		alumno.setDni("25897542");
		alumno.setTelefono("2478558965");
		alumno.setFechaDeNacimiento(LocalDate.of(1983, 10, 23));
		alumno.setDireccion(new Direccion("Calle falsa", 123, "", "2752", "Capitán Sarmiento","Cap Sarm"));
		
		Alumno alumno2 = new Alumno();
		alumno2.setNombre("Esteban Cufré");
		alumno2.setEmail("esteban@gmail.com");
		alumno2.setTelefono("2478547856");
		alumno2.setDni("15698544");
		alumno2.setFechaDeNacimiento(LocalDate.of(1991, 3, 15));
		alumno2.setDireccion(new Direccion("Rivadavia", 147, "", "2752", "Capitán Sarmiento","Cap Sarm"));
		
		Alumno alumno3 = new Alumno();
		alumno3.setNombre("Karina Rivarola");
		alumno3.setEmail("kari@gmail.com");
		alumno3.setTelefono("2478458796");
		alumno3.setDni("24587985");
		alumno3.setFechaDeNacimiento(LocalDate.of(1968, 7, 3));
		alumno3.setDireccion(new Direccion("Alem", 1123, "", "2752", "Capitán Sarmiento","Cap Sarm"));
		
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
		
		
		
		Direccion direccion = new Direccion("Marmol", 855, null, "2752", "Capital Sarmiento","Cap Sarm");
		
		Docente docente = new Docente();
		docente.setNombre("Fede");
		
		Examen examen = new Examen();
		examen.setExamenFinal("Examen final");
		
		Materia materia = new Materia();
		materia.setNombre("Hibernate");
		materia.setAnioEnCarrera(2);
		materia.setDocente("Jorgelina Ceriani");
		materia.setEsPromocionable(true);
		carrera.agregarMateria(materia);
		
		Materia materia2 = new Materia();
		materia2.setNombre("Ingenieria de Software");
		materia2.setAnioEnCarrera(3);
		materia2.setDocente("Federico Aloi");
		materia2.setEsPromocionable(false);
		carrera.agregarMateria(materia2);
		
		
		materia.setAnioEnCarrera(2);
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
		materiaHome.saveOrUpdate(materia2);
		direccionHome.saveOrUpdate(direccion);
		cursadaHome.saveOrUpdate(cursada);
		estudioCursadoHome.saveOrUpdate(titulo);
		carreraHome.saveOrUpdate(carrera3);
		carreraHome.saveOrUpdate(carrera2);
		ts.commit();
	}
}
