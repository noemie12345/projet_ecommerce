package fr.adaming.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.adaming.dao.ICategorieDAO;
import fr.adaming.model.Categorie;

@Service("categorieServiceBean")
public class CategorieService implements ICategorieService {

	@Autowired
	private ICategorieDAO catDAO;
	
	@Override
	public void add(Categorie categorie) {
		// TODO Auto-generated method stub
		catDAO.add(categorie);
	}

	@Override
	public void update(Categorie categorie) {
		// TODO Auto-generated method stub
		catDAO.update(categorie);
	}

	@Override
	public void delete(long id) {
		// TODO Auto-generated method stub
		catDAO.delete(id);
	}

	@Override
	public Categorie getById(long id) {
		// TODO Auto-generated method stub
		return catDAO.getById(id);
	}

	@Override
	public List<Categorie> getAll() {
		// TODO Auto-generated method stub
		return (List<Categorie>) catDAO.getAll();
	}

	@Override
	public Categorie getByNom(String nom) {
		// TODO Auto-generated method stub
		return null;
	}

}
