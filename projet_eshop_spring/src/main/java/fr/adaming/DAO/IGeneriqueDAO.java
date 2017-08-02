package fr.adaming.DAO;

import java.util.Collection;

public interface IGeneriqueDAO<T> {

	public void add(T t);
	
	public void update(T t);
	
	public void delete(int id);
	
	public T getById(int id);
	
	public Collection<T> getAll();
}
