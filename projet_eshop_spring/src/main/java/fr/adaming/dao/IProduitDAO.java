package fr.adaming.dao;

import fr.adaming.model.Produit;

public interface IProduitDAO extends IGeneriqueDAO<Produit>{
	
	public Produit getByNom (Produit produit);
}
