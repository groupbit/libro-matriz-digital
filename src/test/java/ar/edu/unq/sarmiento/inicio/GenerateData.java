package ar.edu.unq.sarmiento.inicio;

import org.hibernate.Session;
import org.hibernate.Transaction;

import ar.edu.unq.sarmiento.hibernate.CarreraHome;
import ar.edu.unq.sarmiento.hibernate.SessionFactoryContainer;
import ar.edu.unq.sarmiento.modelo.Alumno;
import ar.edu.unq.sarmiento.modelo.Carrera;
import ar.edu.unq.sarmiento.modelo.Direccion;

public class GenerateData {

	public static void main(String[] args) {

		SessionFactoryContainer.buildSessionFactory(true);
		Session s = SessionFactoryContainer.getSessionFactory().getCurrentSession();

		Transaction transaction = s.beginTransaction();

		try {
			Direccion dir1 = new Direccion("Alem", 1360, null, "2752", "capitan sarmiento");
			Carrera carrera= new Carrera("Ingles");

			DireccionHome.getInstance().insert(dir1);
			CarreraHome.getInstance().getSession().saveOrUpdate(carrera);

			transaction.commit();
		} catch (RuntimeException e) {
			transaction.rollback();
			throw e;
		} finally {
			s.close();
			SessionFactoryContainer.getSessionFactory().close();
		}

	}

}
