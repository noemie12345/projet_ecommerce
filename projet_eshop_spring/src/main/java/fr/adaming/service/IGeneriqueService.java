package fr.adaming.service;

import java.util.Collection;

public interface IGeneriqueService<T> {

	public void add(T t);

	public void update(T t);

	public void delete(Long id);

	public T getById(Long id);

	public Collection<T> getAll();
}
