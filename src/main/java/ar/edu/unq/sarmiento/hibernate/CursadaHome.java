package ar.edu.unq.sarmiento.hibernate;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import ar.edu.unq.sarmiento.modelo.Cursada;

@Component
public class CursadaHome extends Home<Cursada>{

	private static final long serialVersionUID = 1L;
	
	public List<Cursada> listaDeCursadasOrdenadas(Integer id){
		return this.getSession().createQuery("From Cursada c where alumno_id =: id", Cursada.class).setParameter("id", id)
				.stream().sorted((c1, c2) -> c1.getMateria().getNombre().compareTo(c2.getMateria().getNombre())).sorted((c1,c2)-> Integer.compare(c1.getAnio(),c2.getAnio())).collect(Collectors.toList());
	}
}
