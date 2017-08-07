package fr.adaming.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.dao.IProduitDAO;
import fr.adaming.model.Produit;

@Service("produitServiceBean")
@Transactional
public class ProduitService implements IProduitService {

	@Autowired
	private IProduitDAO produitDAO;
	
	@Override
	public void add(Produit produit) {
		produitDAO.add(produit);
	}

	@Override
	public void update(Produit produit) {
		produitDAO.update(produit);
	}

	@Override
	public void delete(long id) {
		produitDAO.delete(id);
	}

	@Override
	public Produit getById(long id) {
		return produitDAO.getById(id);
	}

	@Override
	public List<Produit> getAll() {
		return (List<Produit>) produitDAO.getAll();
	}

	@Override
	public Produit getByNom(String nom) {
		return produitDAO.getByNom(nom);
	}

}
