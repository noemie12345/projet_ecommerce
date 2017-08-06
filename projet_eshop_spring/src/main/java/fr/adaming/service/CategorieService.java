package fr.adaming.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.dao.ICategorieDAO;
import fr.adaming.model.Categorie;

@Service("categorieServiceBean")
@Transactional
public class CategorieService implements ICategorieService {

	@Autowired
	private ICategorieDAO catDAO;
	
	@Override
	public void add(Categorie categorie) {
		catDAO.add(categorie);
	}

	@Override
	public void update(Categorie categorie) {
		catDAO.update(categorie);
	}

	@Override
	public void delete(long id) {
		catDAO.delete(id);
	}

	@Override
	public Categorie getById(long id) {
		return catDAO.getById(id);
	}

	@Override
	public List<Categorie> getAll() {
		return (List<Categorie>) catDAO.getAll();
	}

	@Override
	public Categorie getByNom(String nom) {
		return catDAO.getByNom(nom);
	}

}
