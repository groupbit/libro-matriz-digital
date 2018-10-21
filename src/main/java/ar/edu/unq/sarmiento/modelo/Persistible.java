package ar.edu.unq.sarmiento.modelo;

import java.io.Serializable;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import org.hibernate.annotations.GenericGenerator;

@MappedSuperclass
public abstract class Persistible implements Serializable {

	private static final long serialVersionUID = 8800435793805290981L;

	@Id
	@GeneratedValue(generator="myGenerator")
	@GenericGenerator(name="myGenerator", strategy = "increment")
	private int id;
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
}
