package ar.edu.unq.sarmiento.hibernate;

import java.time.LocalDate;

import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unq.sarmiento.modelo.Alumno;
import ar.edu.unq.sarmiento.modelo.Carrera;
import ar.edu.unq.sarmiento.modelo.Cursada;
import ar.edu.unq.sarmiento.modelo.Direccion;
import ar.edu.unq.sarmiento.modelo.EstadoCursada;
import ar.edu.unq.sarmiento.modelo.EstudioCursado;
import ar.edu.unq.sarmiento.modelo.Examen;
import ar.edu.unq.sarmiento.modelo.Genero;
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
		Carrera tpi = new Carrera();
		tpi.setNombre("Tecnicatura en Programación Informática");
		tpi.setDuracion(5);
		tpi.setResolucion("1280/52");
		
		Carrera profesoradoIngles = new Carrera();
		profesoradoIngles.setNombre("Profesorado de Inglés");
		profesoradoIngles.setDuracion(4);
		profesoradoIngles.setResolucion("1805/17");
		
		Carrera profesoradoInicial = new Carrera();
		profesoradoInicial.setNombre("Profesorado de Nivel Inicial");
		profesoradoInicial.setDuracion(5);
		profesoradoInicial.setResolucion("5860/16");
		profesoradoInicial.setArchivada(true);
		
		Direccion direccion = new Direccion("Marmol", 855, null, "2752", "Capital Sarmiento","Cap Sarm");
		
		Examen examen = new Examen();
		examen.setTipoDeExamen(TipoDeExamen.FINAL);
		
		Materia materia = new Materia();
		materia.setNombre("Hibernate");
		materia.setAnioEnCarrera(2);
		materia.setDocente("Jorgelina Ceriani");
		materia.setPromocionable(true);
		tpi.agregarMateria(materia);
		
		Materia materia3 = new Materia();
		materia3.setNombre("Estrategía de persistencia");
		materia3.setAnioEnCarrera(3);
		materia3.setDocente("Pablo Murias");
		materia3.setPromocionable(true);
		tpi.agregarMateria(materia3);
		
		Materia materia2 = new Materia();
		materia2.setNombre("Ingenieria de Software");
		materia2.addCorrelativa(materia);
		materia2.addCorrelativa(materia3);
		materia2.setAnioEnCarrera(3);
		materia2.setDocente("Federico Aloi");
		materia2.setPromocionable(false);
		tpi.agregarMateria(materia2);
		
		
		materia3.setAnioEnCarrera(2);
		materia3.setPromocionable(true);
		
		Materia materia4 = new Materia();
		materia4.setNombre("Base de datos 2");
		materia4.addCorrelativa(materia);
		materia4.addCorrelativa(materia2);
		materia4.setAnioEnCarrera(3);
		materia4.setDocente("Federico Aloi");
		materia4.setPromocionable(false);
		tpi.agregarMateria(materia4);
		
		Cursada cursada = new Cursada();
		cursada.setMateria(materia3);
		cursada.setEstado(EstadoCursada.CURSANDO);
		cursada.setAnio(2018);
		cursada.setNotaFinal(7);
		
		Cursada cursada1 = new Cursada();
		cursada1.setMateria(materia2);
		cursada1.setEstado(EstadoCursada.CURSANDO);
		cursada1.setAnio(2018);
		cursada1.setNotaFinal(7);
		
		Cursada cursada2 = new Cursada();
		cursada2.setMateria(materia);
		cursada2.setEstado(EstadoCursada.APROBADA_PROMOCION);
		cursada2.setAnio(2019);
		cursada2.setNotaFinal(8);
	
		Cursada cursada3 = new Cursada();
		cursada3.setMateria(materia3);
		cursada3.setEstado(EstadoCursada.APROBADA_PROMOCION);
		cursada3.setAnio(2017);
		cursada3.setNotaFinal(7);
		
		Cursada cursada4 = new Cursada();
		cursada4.setMateria(materia4);
		cursada4.setEstado(EstadoCursada.APROBADA_PROMOCION);
		cursada4.setAnio(2017);
		cursada4.setNotaFinal(7);
		
		Alumno alumno = new Alumno();
		alumno.setNombre("Juan Rodriguez");
		alumno.setEmail("juancito@gmail.com");
		alumno.setDni("25897542");
		alumno.setTelefono("2478558965");
		alumno.setFechaDeNacimiento(LocalDate.of(1983, 10, 23));
		alumno.setDireccion(new Direccion("Calle falsa", 123, "", "2752", "Capitán Sarmiento","Cap Sarm"));
		alumno.setGenero(Genero.FEMENINO);
		alumno.setCarrera(profesoradoInicial);
		
		Alumno alumno2 = new Alumno();
		alumno2.setNombre("Esteban Cufré");
		alumno2.setEmail("esteban@gmail.com");
		alumno2.setTelefono("2478547856");
		alumno2.setDni("15698544");
		alumno2.setFechaDeNacimiento(LocalDate.of(1991, 3, 15));
		alumno2.setDireccion(new Direccion("Rivadavia", 147, "", "2752", "Capitán Sarmiento","Cap Sarm"));
		alumno2.setGenero(Genero.MASCULINO);
		alumno2.setCarrera(profesoradoIngles);
		
		Alumno alumno3 = new Alumno();
		alumno3.setNombre("Karina Rivarola");
		alumno3.setEmail("kari@gmail.com");
		alumno3.setTelefono("2478458796");
		alumno3.setDni("24587985");
		alumno3.setFechaDeNacimiento(LocalDate.of(1968, 7, 3));
		alumno3.setDireccion(new Direccion("Alem", 1123, "", "2752", "Capitán Sarmiento","Cap Sarm"));
		alumno3.setCarrera(profesoradoInicial);
		EstudioCursado titulo= new EstudioCursado();
		titulo.setAnioEgreso(2016);
		alumno3.setTitulo(titulo);
		alumno3.setGenero(Genero.FEMENINO);
		
		Alumno alumno4 = new Alumno();
		alumno4.setNombre("Nahu");
		alumno4.setEmail("NahuelMartinez@gmail.com");
		alumno4.setTelefono("2478458796");
		alumno4.setDni("24587985");
		alumno4.setFechaDeNacimiento(LocalDate.of(1995, 12, 2));
		alumno4.setDireccion(new Direccion("cabofosatt", 256, "", "2752", "Capitán Sarmiento","Cap Sarm"));
		alumno4.setCarrera(tpi);
		alumno4.addCursada(cursada1);
		alumno4.addCursada(cursada2);
		alumno4.addCursada(cursada3);
		alumno4.addCursada(cursada4);
		alumno4.setGenero(Genero.OTROS);
		
		Transaction ts = sessionFactory.getCurrentSession().beginTransaction();
		alumnoHome.saveOrUpdate(alumno);
		alumnoHome.saveOrUpdate(alumno2);
		alumnoHome.saveOrUpdate(alumno3);
		alumnoHome.saveOrUpdate(alumno4);
		carreraHome.saveOrUpdate(tpi);
		examenHome.saveOrUpdate(examen);
		materiaHome.saveOrUpdate(materia3);
		materiaHome.saveOrUpdate(materia2);
		materiaHome.saveOrUpdate(materia4);
		direccionHome.saveOrUpdate(direccion);
		cursadaHome.saveOrUpdate(cursada);
		cursadaHome.saveOrUpdate(cursada1);
		cursadaHome.saveOrUpdate(cursada2);
		cursadaHome.saveOrUpdate(cursada3);
		cursadaHome.saveOrUpdate(cursada4);
		estudioCursadoHome.saveOrUpdate(titulo);
		carreraHome.saveOrUpdate(profesoradoInicial);
		carreraHome.saveOrUpdate(profesoradoIngles);
		ts.commit();
	}
}
