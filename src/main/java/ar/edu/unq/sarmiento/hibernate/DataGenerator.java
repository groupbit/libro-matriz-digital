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
		
		Materia hibernate = new Materia();
		hibernate.setNombre("Hibernate");
		hibernate.setAnioEnCarrera(2);
		hibernate.setDocente("Jorgelina Ceriani");
		hibernate.setPromocionable(true);
		tpi.agregarMateria(hibernate);
		
		Materia persistencia = new Materia();
		persistencia.setNombre("Estrategía de persistencia");
		persistencia.setAnioEnCarrera(3);
		persistencia.setDocente("Pablo Murias");
		persistencia.setPromocionable(true);
		tpi.agregarMateria(persistencia);
		
		Materia ingSoftware = new Materia();
		ingSoftware.setNombre("Ingenieria de Software");
		ingSoftware.addCorrelativa(hibernate);
		ingSoftware.addCorrelativa(persistencia);
		ingSoftware.setAnioEnCarrera(3);
		ingSoftware.setDocente("Federico Aloi");
		ingSoftware.setPromocionable(false);
		tpi.agregarMateria(ingSoftware);
		
		Materia baseDeDatos2 = new Materia();
		baseDeDatos2.setNombre("Base de datos 2");
		baseDeDatos2.addCorrelativa(hibernate);
		baseDeDatos2.addCorrelativa(ingSoftware);
		baseDeDatos2.setAnioEnCarrera(3);
		baseDeDatos2.setDocente("Federico Aloi");
		baseDeDatos2.setPromocionable(false);
		tpi.agregarMateria(baseDeDatos2);
		
		Materia ingles1 = new Materia();
		ingles1.setAnioEnCarrera(3);
		ingles1.setNombre("Inglés 1");
		ingles1.setDocente("Patricia Ramirez");
		profesoradoIngles.agregarMateria(ingles1);
		
		Cursada cursada = new Cursada();
		cursada.setMateria(persistencia);
		cursada.setEstado(EstadoCursada.CURSANDO);
		cursada.setAnio(2018);
		cursada.setNotaFinal(7);
		
		Cursada cursadaIngSw = new Cursada();
		cursadaIngSw.setMateria(ingSoftware);
		cursadaIngSw.setEstado(EstadoCursada.APROBADA_FINAL);
		cursadaIngSw.setAnio(2018);
		cursadaIngSw.setNotaFinal(7);
		
		Cursada cursadaHibernate = new Cursada();
		cursadaHibernate.setMateria(hibernate);
		cursadaHibernate.setEstado(EstadoCursada.APROBADA_PROMOCION);
		cursadaHibernate.setAnio(2019);
		cursadaHibernate.setNotaFinal(8);
	
		Cursada cursadaPersistencia = new Cursada();
		cursadaPersistencia.setMateria(persistencia);
		cursadaPersistencia.setEstado(EstadoCursada.APROBADA_PROMOCION);
		cursadaPersistencia.setAnio(2017);
		cursadaPersistencia.setNotaFinal(7);
		
		Cursada cursadaBaseDeDatos2 = new Cursada();
		cursadaBaseDeDatos2.setMateria(baseDeDatos2);
		cursadaBaseDeDatos2.setEstado(EstadoCursada.CURSANDO);
		cursadaBaseDeDatos2.setAnio(2017);
		cursadaBaseDeDatos2.setNotaFinal(7);
		
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
		alumno4.addCursada(cursadaHibernate);
		alumno4.addCursada(cursadaPersistencia);
		alumno4.addCursada(cursadaIngSw);
		alumno4.addCursada(cursadaBaseDeDatos2);
		alumno4.setGenero(Genero.OTROS);
		
		Transaction ts = sessionFactory.getCurrentSession().beginTransaction();
		alumnoHome.saveOrUpdate(alumno);
		alumnoHome.saveOrUpdate(alumno2);
		alumnoHome.saveOrUpdate(alumno3);
		alumnoHome.saveOrUpdate(alumno4);
		carreraHome.saveOrUpdate(tpi);
		examenHome.saveOrUpdate(examen);
		materiaHome.saveOrUpdate(persistencia);
		materiaHome.saveOrUpdate(ingSoftware);
		materiaHome.saveOrUpdate(baseDeDatos2);
		direccionHome.saveOrUpdate(direccion);
		cursadaHome.saveOrUpdate(cursada);
		cursadaHome.saveOrUpdate(cursadaIngSw);
		cursadaHome.saveOrUpdate(cursadaHibernate);
		cursadaHome.saveOrUpdate(cursadaPersistencia);
		cursadaHome.saveOrUpdate(cursadaBaseDeDatos2);
		estudioCursadoHome.saveOrUpdate(titulo);
		carreraHome.saveOrUpdate(profesoradoInicial);
		carreraHome.saveOrUpdate(profesoradoIngles);
		ts.commit();
	}
}
