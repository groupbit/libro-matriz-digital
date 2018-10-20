package ar.edu.unq.sarmiento.modelo;

import java.io.Serializable;

public interface Home<T> extends Serializable {
	
	public void insert(T object);
	public void update(T object);
	public void delete(T object);
	

}
